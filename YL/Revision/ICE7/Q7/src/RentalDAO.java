import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalDAO {
    private ArrayList<Rental> rentalList;

    private DVDDAO dvdMgr;
    private PatronDAO patronMgr;

    // constructor
    public RentalDAO() {
        rentalList = new ArrayList<Rental>();

        try {
            patronMgr = new PatronDAO();
            dvdMgr = new DVDDAO();
            
        } catch (DataException e) {
            //TODO: handle exception
            System.out.println("Internal Error");
        }
    }

    

    private void load() {
        rentalList = new ArrayList<Rental>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File("data/patron.csv"));
            sc.useDelimiter(",|\n|\r\n");
            while (sc.hasNext()) {
                int id = sc.nextInt();
                Patron p = patronMgr.retrieve(sc.next());
                DVD d = dvdMgr.retrieve(sc.next());
                rentalList.add(new Rental(id, p, d));
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage());
        } finally {
            if (sc != null) sc.close();
        }

    }

    // adds a new Rental to the rentalList. This method takes in the patron.csv & dvd and creates an ID for the Rental
    public void add(Patron patron, DVD dvd) {
        int nextId = rentalList.size() + 1;
        Rental rental = new Rental(nextId, patron, dvd);
        rentalList.add(rental);

        try {
            FileWriter _writer = new FileWriter(new File("data/rental.csv"));
            _writer.append("");
            _writer.close();

            FileWriter writer = new FileWriter(new File("data/rental.csv"), true);
            for (Rental r : rentalList) {
                writer.append(String.format("%d,%s,%s%n", r.getId(), r.getPatron().getUsername(), r.getDVD().getTitle()));                
            }
            writer.close();
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    // returns the ArrayList of Rental objects
    public ArrayList<Rental> retrieveAll() {
        return rentalList;
    }


}
