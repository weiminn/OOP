
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DVDDAO {
    // declares the dvdList variable
    private ArrayList<DVD> dvdList = new ArrayList<DVD>();


    // default constructor
    public DVDDAO() throws DataException{
        load();
        // creates the ArrayList object to contain DVDs
//        dvdList = new ArrayList<DVD>();
//
//        // declares and creates all the dvd objects
//        DVD dvd1 = new DVD(1, "Twilight Zone");
//        DVD dvd2 = new DVD(2, "Immortals");
//        DVD dvd3 = new DVD(3, "Puss in boots");
//        DVD dvd4 = new DVD(4, "Adventure of Tintin");
//
//        // add the objects to the ArrayList
//        dvdList.add(dvd1);
//        dvdList.add(dvd2);
//        dvdList.add(dvd3);
//        dvdList.add(dvd4);
//
//        // another way to do this!
//        dvdList.add(new DVD(5, "Transformer"));
    }

    private void load() throws DataException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("data/dvd.csv"));
            sc.useDelimiter(",|\n|\r\n");
            while (sc.hasNext()) {
                dvdList.add(new DVD(sc.nextInt(), sc.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataException(e.getLocalizedMessage());
        } finally {
            if (sc != null) sc.close();
        }
    }

    // returns the whole ArrayList of DVD objects
    public ArrayList<DVD> retrieveAll() {
        return dvdList;
    }

    // returns a single DVD object of a particular title, 
    // or null if there is no matching DVD
    public DVD retrieve(String title) {
        for (int i = 0; i < dvdList.size(); i++) {
            DVD d = dvdList.get(i);
            if (d.getTitle().equals(title)) {
                return d;
            }
        }
        return null;
    }

    // adds a new DVD into dvdList with the specified title
    // the ID of this new DVD is automatically generated
    public void add(String title) {
        int nextId = dvdList.size() + 1;
        dvdList.add(new DVD(nextId, title));
    }

}