// This class represents a Patron with an id, username and name
// this class has no setters, which means that the only way to set the values
// of its attributes is during construction.

public class Patron {
    private int id;
    private String username;
    private String name;

    // the only constructor
    public Patron(int id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    // getter for id
    public int getId() {
        return id;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for username
    public String getUsername() {
        return username;
    }
}
