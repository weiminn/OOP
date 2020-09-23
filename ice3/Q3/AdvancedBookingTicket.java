public class AdvancedBookingTicket extends Ticket {
    private int numDaysInAdvance;

    public AdvancedBookingTicket(String title, int numDaysInAdvance) {
        super(title);
        this.numDaysInAdvance = numDaysInAdvance;
    }

    public double calculatePrice(){
        double discount = 0.0;
        double discountedPrice;
        for (int i = 0; i < numDaysInAdvance; i++){
            discount += .5;
        }

        if (discount >= (super.calculatePrice() / 2)){
            discountedPrice = (super.calculatePrice() / 2);
        } else {
            discountedPrice = super.calculatePrice() - discount;
        }

        return discountedPrice;
    }
    
}
