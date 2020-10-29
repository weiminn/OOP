import java.time.*;

public class DatesAndTimes {
    public static void main(String[] args) {

        //no constructors for any methods
        //WONT COMPILE => new LocalDate();
        
        //just Date
        //no time or timezone
        LocalDate lDate = LocalDate.now(); //prints "yyyy-mm-dd"
        LocalDate _lDate = LocalDate.of(2020, Month.JANUARY, 21);
        _lDate = LocalDate.of(2020, 1, 21);
        //if day >= 32, throws DateTimeException        

        //just Time
        //no date or timezone
        LocalTime lTime = LocalTime.now(); //prints "HH:mm:SS.sss"

        //Can be flexible with parameters
        LocalTime _lTime = LocalTime.of(13, 45);
        _lTime = LocalTime.of(13, 45, 30);
        _lTime = LocalTime.of(13, 45, 30, 432);

        //both Date and Time
        //no timezone
        LocalDateTime ldTime = LocalDateTime.now(); // prints "2015-01-20T12:45:18.401"
        //T to seperate date and time during conversion

        //combine date and time paraters
        LocalDateTime dt1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30); // prints "2015-01-20T12:45:18.401"
        LocalDateTime dt2 = LocalDateTime.of(_lDate, _lTime); // prints "2015-01-20T12:45:18.401"
        
        //UNIX
        long epochDays = lDate.toEpochDay(); //no. of days since Jan 1 1970
    }
    
}
