package com.smuxoopg1t2.model;

import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @Entitiy Represents the Vessel Entity
 */
@Entity
@Table(name="User")
public class User implements Serializable {


    /**
     * @id is inherited from javax.persistence.Id，
     * indicating the member field below is the primary key of current entity
     * @GeneratedValue annotation is to configure the way of increment of the
     * specified column(field).
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String email;

    private String hashedPassword;

    private String name;


    /**
     * @ManyToMany annotation is used to create the many-to-many relationship
     * */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    //FetchType.EAGER automatically retrieves all the corresponding vessel
    // records from the database
    //CascadeType.PERSIST when saving user record, the favourite vessels records
    // are also saved
    @JoinTable(
            name = "favourite",
            joinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "vessel", referencedColumnName = "name"),
                    @JoinColumn(name = "incoming_voyage",
                            referencedColumnName = "incomingVoyage"),
                    @JoinColumn(name = "shift_seq_n",
                            referencedColumnName = "shiftSeqN")
            }
    )
    private Set<Vessel> favourites = new HashSet<>();


    public Set<Vessel> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Vessel> favourites) {
        this.favourites = favourites;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    //FetchType.EAGER automatically retrieves all the corresponding vessel
    // records from the database
    //CascadeType.PERSIST when saving user record, the favourite vessels
    // records are also saved

    @JoinTable(
            name = "subscription",
            joinColumns = {@JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "vessel",
                            referencedColumnName = "name"),
                    @JoinColumn(
                            name = "incoming_voyage",
                            referencedColumnName = "incomingVoyage"),
                    @JoinColumn(
                            name = "shift_seq_n",
                            referencedColumnName = "shiftSeqN")
            }
    )

    private Set<Vessel> subscriptions = new HashSet<>();



    /*
     * GETTERS
     */


    /**
     * Gets the id for this user obj
     *
     * @return the id of the user
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the email for this user obj
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the hashedpassword for this user obj
     *
     * @return the hashed password of the user
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * Gets the name for this user obj
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the subscriptions this user has
     *
     * @return the Set of Vessel Object that this user has subscribed to
     */
    public Set<Vessel> getSubscriptions() {
        return subscriptions;
    }


    /*
     * SETTERS
     */

    /**
     * Sets the id for this user obj
     *
     * @param id sets the id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Sets the email for this user obj
     *
     * @param email sets the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the password for this user obj by hashing it before storing it
     *
     * @param password the raw password yet to be hashed
     * */
    public void setPassword(String password) {
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Sets the name for this user obj
     *
     * @param name the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the subscriptions this user has
     *
     * @params updates the Set of Vessel subscriptions the user has
     */
    public void setSubscriptions(Set<Vessel> subscriptions) {
        this.subscriptions = subscriptions;
    }


    /**
     * Returns a Map of ids, emails and names
     */
    public Map<String, Object> toHashedMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("email", this.email);
        map.put("name", this.name);

        return map;
    }

    /**
     * Overrides the equal method and is only equal of vessel id is the same
     *
     * @param o the User Object
     * @return true or false to state if it is equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    /**
     * Overrides the hashCode to use id to hash
     *
     * @return the hashed id int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}