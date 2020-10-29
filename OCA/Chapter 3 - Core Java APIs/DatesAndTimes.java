import java.time.*;

public class DatesAndTimes {
    public static void main(String[] args) {
        
        //just Date
        //no time or timezone
        LocalDate lDate = LocalDate.now();
        LocalDate _lDate = LocalDate.of(2020, Month.JANUARY, 21);
        _lDate = LocalDate.of(2020, 1, 21);
        //yyyy-mm-dd

        //just Time
        //no date or timezone
        LocalTime lTime = LocalTime.now();
        LocalTime _lTime = LocalTime.of(13);
        _lTime = LocalTime.of(13, 45);
        _lTime = LocalTime.of(13, 45, 30);
        _lTime = LocalTime.of(13, 45, 30, 432);
        //HH:mm:ss.sss

        //both Date and Time
        //no timezone
        LocalDateTime ldTime = LocalDateTime.now();
        //2015-01-20T12:45:18.401
        //T to seperate date and time during conversion

        
    }
    
}
