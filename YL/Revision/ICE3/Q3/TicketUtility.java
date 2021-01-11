import java.util.ArrayList;

public class TicketUtility {
    public static double calculateAverageTicketPrice(ArrayList<Ticket> ticketList){
        if(ticketList == null) return 0.0;
        if(ticketList.size() == 0) return 0.0;

        double total = 0;

        for(Ticket t: ticketList){
            total += t.calculatePrice();
        }

        return total/ticketList.size();
    }
    
}
