import java.util.Scanner;
import java.util.ArrayList;

// this class represents menu operations, including interaction with the user

public class RentalMenu {
    private DVDDAO dvdMgr;
    private PatronDAO patronMgr;
    private RentalDAO rentalMgr;

    // constructor
    public RentalMenu() {
        dvdMgr = new DVDDAO();

        try {
            patronMgr = new PatronDAO();
            rentalMgr = new RentalDAO();
            
        } catch (DataException e) {
            //TODO: handle exception
            System.out.println("Internal Error");
        }
    }

    // prints out the menu to the console
    public void display() {
        System.out.println("== DVD Rental ==");
        System.out.println("1. List all DVDs");
        System.out.println("2. Add a DVD");
        System.out.println("3. Rent a DVD");
        System.out.println("4. List all rentals");
        System.out.println("5. Quit Application");
        System.out.println();
        System.out.print("Please enter your choice:");
    }

    // takes in user input and invokes the relevant methods
    // call readOption() after you have called display()
    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            display();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    processListAllDVDs();
                    break;
                case 2:
                    processAddDVD();
                    break;
                case 3:
                    processRentDVD();
                    break;
                case 4:
                    processListAllRentals();
                    break;
                case 5:
                    System.out.println("bye bye");
                    break;
                default:
                    System.out.println("Enter a choice between 1 to 5 ");
            }
        } while (choice != 5);
    }

    // prints out all the rentals so far
    private void processListAllRentals() {
        System.out.println("== DVD Rental::List all Rentals ==");
        ArrayList<Rental> rentalList = rentalMgr.retrieveAll();
        for (int i = 0; i < rentalList.size(); i++) {
            Rental rental = rentalList.get(i);
            Patron patron = rental.getPatron();
            DVD dvd = rental.getDVD();
            System.out.println((i + 1) + ". " + dvd.getTitle() + " borrowed by " + patron.getName());
        }
        System.out.println();
    }

    // gets new DVD title from user and adds it to the current list of DVDs
    public void processAddDVD() {
        System.out.println();
        System.out.println("== DVD Rental::Add DVD ==");
        System.out.print("Enter the title > ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        dvdMgr.add(title);
        System.out.println("DVD added successfully!");
        System.out.println();
    }

    // prints out whole list of current DVDs
    public void processListAllDVDs() {
        System.out.println();
        System.out.println("== DVD Rental::List all DVDs ==");
        ArrayList<DVD> dvdList = dvdMgr.retrieveAll();
        for (int i = 0; i < dvdList.size(); i++) {
            DVD dvd = dvdList.get(i);
            System.out.println((i + 1) + ". " + dvd.getTitle());
        }
        System.out.println();
    }

    // prompts user for username, DVD title and adds a record to the list of rentals
    public void processRentDVD() {        
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("== DVD Rental::Rent a DVD ==");

        // prompts for username
        System.out.print("Enter the username > ");
        String username = sc.nextLine();

        // prompts for the dvd's title
        System.out.print("Enter the DVD's title > ");
        String title = sc.nextLine();

        DVD dvd = dvdMgr.retrieve(title);
        if (dvd == null) {
            System.out.println("No such DVD\n");
            return;
        }
        Patron patron = patronMgr.retrieve(username);
        if (patron == null) {
            System.out.println("No such username\n");
            return;
        }

        rentalMgr.add(patron, dvd);
        System.out.println("DVD rented successfully!");
        System.out.println();
    }
}