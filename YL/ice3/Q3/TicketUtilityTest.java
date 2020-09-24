import java.util.ArrayList;


public class TicketUtilityTest {
    public static void main(String[] args) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        Ticket t1 = new Ticket("I love OOAD");
        Ticket t2 = new Ticket("I love Inheritance");
        Ticket t3 = new Ticket("Inheritance Rocks");
        Ticket t4 = new AdvancedBookingTicket("I worry for u", 2);
        Ticket t5 = new AdvancedBookingTicket("Dan Xin Ni", 10);

        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        tickets.add(t5);


        System.out.println("Ticket 1: " + t1.calculatePrice());
        System.out.println("Ticket 2: " + t2.calculatePrice());
        System.out.println("Ticket 3: " + t3.calculatePrice());
        System.out.println("Ticket 4: " + t4.calculatePrice());
        System.out.println("Ticket 5: " + t5.calculatePrice());

        System.out.println();
        System.out.println("Test 1:");
        System.out.println("Expected: 0.0");
        System.out.println("Actual  : " + TicketUtility.calculateAverageTicketPrice(null));

        System.out.println();
        System.out.println("Test 2:");
        System.out.println("Expected: 0.0");
        System.out.println("Actual  : " + TicketUtility.calculateAverageTicketPrice(new ArrayList<Ticket>()));

        System.out.println();
        System.out.println("Test 3:");
        System.out.println("Expected: 6.271");
        System.out.println("Actual  : " + TicketUtility.calculateAverageTicketPrice(tickets));

    }
}
