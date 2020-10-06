import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatronDAO {
    private ArrayList<Patron> patronList = new ArrayList<Patron>();

    // default constructor
    public PatronDAO() throws DataException {
        load();
        /*
        patronList = new ArrayList<Patron>();
    
        // For this example, hardcode the Patron list
        Patron p1 = new Patron(1, "apple", "Apple Lee");
        Patron p2 = new Patron(2, "billy", "Billy Jiang");
        Patron p3 = new Patron(3, "cindy", "Cindy Koh");
        Patron p4 = new Patron(4, "danny", "Danny Shen");
        Patron p5 = new Patron(5, "elaine", "Elaine Tan");

        patronList.add(p1);
        patronList.add(p2);
        patronList.add(p3);
        patronList.add(p4);
        patronList.add(p5);
        */
    }

    private void load() throws DataException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("data/patron.csv"));
            sc.useDelimiter(",|\n|\r\n");
            while (sc.hasNext()) {
                patronList.add(new Patron(sc.nextInt(), sc.next(), sc.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataException(e.getMessage());
        } finally {
            if (sc != null) sc.close();
        }

    }
    // returns a Patron object with the matching username.
    // returns null if there is no matching username
    public Patron retrieve(String username) {
        for (int i = 0; i < patronList.size(); i++) {
            Patron p = patronList.get(i);
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        // if program reaches here, it means that there is no matching username
        // hence, return null
        return null;
    }

    // returns whole ArrayList of Patron objects
    public ArrayList<Patron> retrieveAll() {
        return patronList;
    }
}
