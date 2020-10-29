import java.time.LocalDateTime;
import java.time.Month;

public class ManipulatingDateTime {
    public static void main(String[] args) {
        LocalDateTime datetime = LocalDateTime.of(2018, Month.AUGUST, 18, 12, 43, 57);

        //if smaller degree values are not specified, java will automatically add the values

        //Manipulate Date => Only for Date and DateTime
        datetime.plusDays(10);
        datetime.plusMonths(10);
        datetime.plusYears(10);
        datetime.minusDays(10);
        datetime.minusMonths(10);
        datetime.minusYears(10);
        //VALUE NOT UPDATE | Immutable type
        //Need to assign

        //Manipulate time => Only for Time and DateTime
        //can also chain
        datetime = datetime.plusSeconds(10).plusMinutes(10).plusHours(10).minusSeconds(10).minusMinutes(10).minusHours(10);
    }
    
}
