import java.io.*;
import java.util.*;

public class RentalDAO {
    private ArrayList<Rental> rentalList;

    // constructor
    public RentalDAO() {
        rentalList = new ArrayList<Rental>();
        load();
    }

    // adds a new Rental to the rentalList. This method takes in the patron.csv & dvd and creates an ID for the Rental
    public void add(Patron patron, DVD dvd) {
        int nextId = rentalList.size() + 1;
        Rental rental = new Rental(nextId, patron, dvd);
        rentalList.add(rental);

        try(FileWriter writer = new FileWriter("data/rental.csv", false)){
            for (Rental rental2 : rentalList) {
                writer.append(
                    rental2.getId() + "," + rental2.getPatron().getUsername() + "," +
                    rental2.getDVD().getTitle() + "\n"
                );
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    // returns the ArrayList of Rental objects
    public ArrayList<Rental> retrieveAll() {
        return rentalList;
    }

    private void load() throws DataException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("data/rental.csv"));
            sc.useDelimiter(",|\n|\r\n");
            while (sc.hasNext()) {

                int id = sc.nextInt();
                // System.out.println("ID: " + id);
                Patron p = (new PatronDAO()).retrieve(sc.next());
                // System.out.println("Patron: " + p.getUsername());
                DVD d = (new DVDDAO()).retrieve(sc.next());


                rentalList.add(new Rental(id, p, d));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataException(e.getMessage());
        } finally {
            if (sc != null) sc.close();
        }
    }


}
