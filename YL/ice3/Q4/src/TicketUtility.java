import ticketing.entity.Ticket;
import java.util.*;

public class TicketUtility {

    public static double calculateAverageTicketPrice(ArrayList<Ticket> ticketList){
        if(ticketList != null){
            if(ticketList.size() > 0){
                double total = 0;
                for(int i = 0; i < ticketList.size(); i++){
                    total += ticketList.get(i).calculatePrice();
                }

                return total/ticketList.size();
            } else {
                return 0.0;
            }

        } else {
            return 0.0;
        }

    }

}
