import java.util.*;
import java.text.*;

/**
 * The SISDate class contains utility methods to facilitate the handling of Date objects
 */
public class SISDate {
    private Date dateTime;

    /**
     * Default constructor for SISDate class
     * SISDate object is set to current date and time
     */
    public SISDate() {
        dateTime = new Date();
    }

    /**
     * Specific constructor for SISDate class that
     * creates a SISDate object by converting date represented in String format
     *
     * @param strDateTime date and time representation in "dd/MM/yyyy HH:mm" (24 hr format))
     */
    public SISDate(String strDateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            dateTime = sdf.parse(strDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Date getDateTime() {
        return dateTime;
    }

    private void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Compares if this SISDate object is equal to another SISDate object
     *
     * @param anotherSISDate another SISDate object for comparison
     * @return boolean
     */
    public boolean equals(SISDate anotherSISDate) {
        return this.dateTime.equals(anotherSISDate.getDateTime());
    }

    /**
     * Compares if this SISDate object occurs at a later date/time
     * than another SISDate object
     *
     * @param anotherSISDate another SISDate object for comparison
     * @return boolean
     */
    public boolean after(SISDate anotherSISDate) {
        return this.dateTime.after(anotherSISDate.getDateTime());
    }

    /**
     * Compares if this SISDate object occurs at an earlier date/time
     * than another SISDate object
     *
     * @param anotherSISDate another SISDate object for comparison
     * @return boolean
     */
    public boolean before(SISDate anotherSISDate) {
        return this.dateTime.before(anotherSISDate.getDateTime());
    }

    /**
     * Computes the end date and time given number of hours elapsed
     *
     * @param hrsBooked number of hours elapsed after this SISDate
     * @return the end date and time of the booking
     */
    public SISDate computeEndDate(int hrsBooked) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateTime);
        try {
            calendar.add(Calendar.HOUR_OF_DAY, hrsBooked);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        SISDate end = new SISDate();
        end.setDateTime(calendar.getTime());
        return end;
    }

    /**
     * Returns the textual representation of a SISDate object
     * in "dd/MM/yyyy HH:mm" format
     *
     * @return the textual representation of SISDate object
     */
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(dateTime);
    }
}
