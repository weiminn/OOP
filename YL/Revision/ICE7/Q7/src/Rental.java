// represents a Rental object. Each Rental has an id, dvd, patron and dueDate
// this class has no setters

public class Rental {
    private int id;
    private DVD dvd;
    private Patron patron;
    private SISDate dueDate;

    // constructor
    public Rental(int id, Patron patron, DVD dvd) {
        this.id = id;
        this.patron = patron;
        this.dvd = dvd;
        // compute due date 24 hrs x 3 days from today
        SISDate today = new SISDate();
        dueDate = today.computeEndDate(24 * 3);
    }

    // getters
    public int getId() {
        return id;
    }

    public Patron getPatron() {
        return patron;
    }

    public DVD getDVD() {
        return dvd;
    }

    public SISDate getDueDate() {
        return dueDate;
    }
}
