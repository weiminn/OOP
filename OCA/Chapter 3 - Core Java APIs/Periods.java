import java.time.*;

public class Periods {
    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2018, Month.AUGUST, 18, 12, 43, 57);
        LocalDateTime dt2 = LocalDateTime.of(2018, Month.SEPTEMBER, 20, 12, 43, 57);

        while (dt1.isBefore(dt2)) {
            //increment dt1 untill it hits dt2
            dt1 = dt1.plusDays(1);
        }

        //Time Periods
        Period yearAndWeek = Period.of(1, 10, 7); // 1 year, 10 months and 7 days 
        Period annually = Period.ofYears(2); 
        Period monthly = Period.ofMonths(2); 
        Period weekly = Period.ofWeeks(2); 
        Period daily = Period.ofDays(2); 

        //can use to manipulate DateTime and Date with periods
        dt2 = dt2.plus(Period.ofDays(3));

        //can NOT manipulate Time with Period
        LocalTime.of(3, 32).plus(Period.ofDays(2)); // thorws UnsupportedTemporalTypeException


    }
    
}
