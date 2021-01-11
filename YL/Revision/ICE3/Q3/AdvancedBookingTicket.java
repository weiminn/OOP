
public class AdvancedBookingTicket extends Ticket {
    private int numDaysInAdvance;

    public AdvancedBookingTicket(String title, int numDaysInAdvance) {
        super(title);
        this.numDaysInAdvance = numDaysInAdvance;
    }

    public double calculatePrice(){
        return Math.max(super.calculatePrice()/2, super.calculatePrice()-(0.5*numDaysInAdvance));
    }
    
}
