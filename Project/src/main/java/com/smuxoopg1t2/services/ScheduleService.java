package com.smuxoopg1t2.services;

import com.smuxoopg1t2.model.Vessel;
import com.smuxoopg1t2.repository.IVesselRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.context.event.EventListener;

//Imports HttpEntity, HttpHeaders, HttpStatus, ResponseEntity
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.io.IOException;
import java.time.LocalDate;

// Imports Map,HashMap,LinkedHashMap,ArrayList
import java.util.*;

/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class ScheduleService {

	private static final Logger log = LoggerFactory.getLogger(
	        ScheduleService.class);

    /**
     * @Autowired is used to mark a dependency which Spring is going to resolve
     * and inject automatically.
     */
    @Autowired
    private VesselService vesselService;

    @Autowired
    private IVesselRepository vesselRepository;

    @Value("${api.key}")
    private String apiKey;
    
    /**
     * Pulls Vessel Information for today and the next 7 days from API endpoint
     * on Server Startup if the vessel table is empty. This ensure that if this
     * is the first time server is started up on a new machine, the Vessel Table
     * is not empty.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void onServerStartUp() {
        if (vesselRepository.count() == 0) {
            log.info("Pulling hourly Vessel and weekly Vessel data on startup");
            retrieveForTodayHourly(); // Pull for today
            retrieveForThisWeek();    // Pull for the next 7 days
        }
    }


    /**
     * This method triggers the pulling of Vessel information from the API
     * endpoint every hour of the day for the dates:
     *        from : Today
     *        To   : Today
     *
     * ${cron.retrieve.today} values are taken from application properties
     */
    @Scheduled(cron = "${cron.retrieve.today}")
    public void retrieveForTodayHourly(){
        LocalDate today = LocalDate.now();;
        log.info("Pulling hourly Vessel data");
        retrieveVessel(today.toString(), today.toString());
    }

    /**
     * This method triggers the pulling of Vessel information from the API
     * endpoint everyday at 00:00hrs:
     *       from : 1 day later (Tomorrow)
     *       To   : 7 days later (excluding today)
     *
     * Since the method retrieveForTodayHourly() will get the values for today
     * every hour including at 00:00, we do not
     * have to include today's date.
     *
     * ${cron.retrieve.week} values are taken from application properties*
     */
    @Scheduled(cron = "${cron.retrieve.week}")
    public void retrieveForThisWeek(){
        //The next 7 days
        LocalDate fromDate = LocalDate.now().plusDays(1);
        LocalDate toDate   = LocalDate.now().plusDays(7);
        log.info("Pulling weekly Vessel data");
        retrieveVessel(fromDate.toString(), toDate.toString());
    }

    /**
     *
     * The actual method that retrieves the Vessel information from the API
     * endpoint
     *
     * This method is triggered by
     *   1. retrieveForTodayHourly()
     *   2. retrieveForThisWeek()
     * automatically via the scheduled cron
     *
     *
     * @param from the from date to be entered in the body of the API call
     * @param to   the to date to be entered in the body of the API call
     *
     * Once the endpoints have been pulled for the latest Vessel information
     *  1. createVesselObj() creates a Vessel Object from the
     *             values retrieved form the REST endpoint
     *  2. update() compares the Vessel info against the DB and does the
     *             necessary updating accordingly
     */
    public void retrieveVessel(String from, String to) {
        log.info("Pulling data");
        final String url = "https://api.pntestbox.com/vsspp/pp/bizfn/" +
                "berthingSchedule/retrieveByBerthingDate/v1.2";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Apikey", apiKey);

        Map<String, Object> map = new HashMap<>();
        map.put("dateFrom", from);
        map.put("dateTo", to);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url,
                entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK){
            log.info("Request Successful");
            ObjectMapper mapper = new ObjectMapper();
            try{
                Map<String, Object> jsonOutput = mapper.readValue(
                        response.getBody(), Map.class);
                if(jsonOutput.get("errors") == null){
                    ArrayList<LinkedHashMap> results =
                            (ArrayList<LinkedHashMap>)jsonOutput.get("results");
                    for (LinkedHashMap<String, Object> result: results) {
                        if(result.get("abbrVslM") != null
                                && result.get("inVoyN") != null
                                && result.get("shiftSeqN") != null){
                            Vessel vessel =
                                    vesselService.createVesselObj(result);
                            vesselService.update(vessel);
                        }
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}