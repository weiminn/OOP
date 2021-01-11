package com.smuxoopg1t2.model;

// Imports Entity, EmbeddedId, Column, ManyToMany, CascadeType, FetchType;
import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Entitiy Represents the Vessel Entity
 */
@Entity
public class Vessel implements Serializable {
    /**
     * This key is embedded in the table's corresponding entity class as the
     * composite primary key by using the @EmbeddedId annotation on a field of
     * the @Embeddable type.
     * vesselIdentity Contains abbrVsIM, inVoyN and shiftSeqN
     */
    @EmbeddedId
    private VesselIdentity vesselIdentity;

    /**
     * @Column Specifies the mapped column for a persistent property or field.
     * */
    @Column(nullable = true)
    private String outVoyageNumber;

    // Acts as the first time (This value should never change)
    @Column(nullable = true)
    private LocalDateTime berthingTime;

    @Column(nullable = true)
    private LocalDateTime departingTime;

    @Column(nullable = true)
    private String berthNumber;

    @Column(nullable = true)
    private String status;

    @Column(nullable = true)
    private int berthingTimeChangeCount;

    // Acts as the latest time updated
    // (This is the only value that keeps changing for berth timing)
    @Column(nullable = true)
    private LocalDateTime updatedBerthingTime;

    /**
     * @ManyToMany annotation is used to create the many-to-many relationship
     * */
    @ManyToMany(mappedBy = "favourites", cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Set<User> favouritedBy = new HashSet<>();

    @ManyToMany(mappedBy = "subscriptions", cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Set<User> subscribedBy = new HashSet<>();


    /**
     * Constructs a Default Vessel object
     */
    public Vessel() { }


    /**
     * Constructs a new Vessel Object with its composite primary keys
     *
     * @param vesselIdentity  the unique identifier consisting of Vessels Short
     *                        Name(abbrVsIM), Incoming Voyage Number(inVoyN) &
     *                        shiftSeqN
     */
    public Vessel(VesselIdentity vesselIdentity) {
        this.vesselIdentity = vesselIdentity;
    }

    /**
     * Constructs a specific Vessel object
     *
     * @param vesselIdentity  the unique identifier consisting of Vessels Short
     *                        Name(abbrVsIM), Incoming Voyage Number(inVoyN) &
     *                        shiftSeqN
     * @param outVoyageNumber the Outgoing Voyage Number
     * @param berthingTime    the Berthing Time
     * @param departingTime   the Departing Time
     * @param berthNumber     the Berth Number
     * @param status          the Vessel Status - E.g. BERTHING, ALONGSIDE or
     *                        UNBERTHED
     */
    public Vessel(VesselIdentity vesselIdentity, String outVoyageNumber,
                  LocalDateTime berthingTime, LocalDateTime departingTime,
                  String berthNumber, String status) {
        this.vesselIdentity = vesselIdentity;
        this.outVoyageNumber = outVoyageNumber;
        this.berthingTime = berthingTime;
        this.departingTime = departingTime;
        this.berthNumber = berthNumber;
        this.status = status;
        this.berthingTimeChangeCount = 0;
    }

    /*
     * GETTERS
     */

    /**
     * Gets the Vessel Identity which is the unique identifier to identify this
     * Vessel
     *
     * @return  the vessel's identity which consists of Vessels Short
     * Name(abbrVsIM), Incoming Voyage Number(inVoyN) and shiftSeqN
     */
    public VesselIdentity getVesselIdentity() {
        return vesselIdentity;
    }

    /**
     * Gets the Outgoing Voyage Number of the Vessel
     *
     * @return the Outgoing Voyage Number
     */
    public String getOutVoyageNumber() {
        return this.outVoyageNumber;
    }

    /**
     * Gets the Berthing Time of the Vessel
     *
     * @return LocalDateTime Object containing the berthing time
     */
    public LocalDateTime getBerthingTime() {
        return berthingTime;
    }

    /**
     * Gets the Depating Time of the Vessel
     *
     * @return LocalDateTime Object containing the departing time
     */
    public LocalDateTime getDepartingTime() {
        return departingTime;
    }

    /**
     * Gets the Berthing Number of the Vessel
     *
     * @return the Berthing Number
     */
    public String getBerthNumber() {
        return berthNumber;
    }

    /**
     * Gets the Status of the Vessel
     *
     * @return the Vessel Status - E.g. BERTHING, ALONGSIDE or UNBERTHED
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the number of Times the Berthing time has changed
     *
     * @return the number of Times the Berthing time has changed
     */
    public int getBerthingTimeChangeCount() {
        return berthingTimeChangeCount;
    }

    /**
     * Gets the latest updated Berthing Time of the Vessel
     *
     * @return LocalDateTime Object containing the latest berthing time
     */
    public LocalDateTime getUpdatedBerthingTime() {
        return updatedBerthingTime;
    }


    /**
     * Gets the list of users in a Set that has vessels favourited this vessel
     * record
     *
     * @return a Set of User Objects that has favourited to this VesselObject
     */
    public Set<User> getFavouritedBy() {
        return favouritedBy;
    }

    /**
     * Gets the list of users in a Set that has vessels subscribed to
     * this vessel record
     *
     * @return a Set of User Objects that has subscribed to this VesselObject
     */
    public Set<User> getSubscribedBy() {
        return subscribedBy;
    }


    /*
     * SETTERS
     */

    /**
     * Sets the berthing time for this vessel obj
     *
     * @param berthingTime the vessel berthing time in LocalDateTime
     */
    public void setBerthingTime(LocalDateTime berthingTime) {
        this.berthingTime = berthingTime;
    }

    /**
     * Sets the status  for this vessel obj
     *
     * @param status sets the Vessel Status - E.g. BERTHING, ALONGSIDE or
     *               UNBERTHED
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the berthing time change count
     *
     * @param berthingTimeChangeCount updates the number of time the berthing
     *                                time has changed
     */
    public void setBerthingTimeChangeCount(int berthingTimeChangeCount) {
        this.berthingTimeChangeCount = berthingTimeChangeCount;
    }

    /**
     * Sets the vessels updated berthing time
     *
     * @param updatedBerthingTime sets the new updated berth time LocalDateTime
     */
    public void setUpdatedBerthingTime(LocalDateTime updatedBerthingTime) {
        this.updatedBerthingTime = updatedBerthingTime;
    }

    /**
     * Overrides the equal method and is only equal of vessel Identity is the
     * same
     *
     * @param o the User Object
     * @return true or false to state if it is equal or not
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vessel vessel = (Vessel) o;
        return vesselIdentity.equals(vessel.vesselIdentity);
    }

    /**
     * Overrides the hashCode to use vesselIdentity to hash
     *
     * @return the hashed id int
     */
    @Override
    public int hashCode() {
        return Objects.hash(vesselIdentity);
    }

    /**
     * Overrides the toString to show vessel name, incoming voyage, shiftseqN,
     * outgoing voyage, berthing time, departing time, berth number, status and
     * berthing time change count.
     */
    @Override
    public String toString() {
        return String.format("Vessel [name=%s, incomingVoyageNumber=%s, " +
                        "shiftSeq=%s, outVoyageNumber=%s, berthingTime=%s, " +
                        "departingTime=%s, berthNumber=%d, status=%s, " +
                        "berthingTimeChangeCount=%d]",
                this.vesselIdentity.getName(),
                this.vesselIdentity.getIncomingVoyage(),
                this.vesselIdentity.getShiftSeqN(),
                this.outVoyageNumber,
                this.berthingTime,
                this.departingTime,
                this.berthNumber,
                this.status,
                this.berthingTimeChangeCount);
    }


    public Map<String, Object> toHashedMapFavouritesANDSubscriptions(){
        Map<String,Object> map = new HashMap<>();
        map.put("name", this.vesselIdentity.getName());
        map.put("incomingVoyageNumber", this.vesselIdentity.getIncomingVoyage());
        map.put("shiftSeqN", this.vesselIdentity.getShiftSeqN());

        return map;
    }

    public Map<String, Object> toHashedMap(boolean isFavourited,
                                           boolean isSubscribed){

        Map<String,Object> map = new HashMap<>();
        map.put("name", this.vesselIdentity.getName());
        map.put("incomingVoyageNumber",this.vesselIdentity.getIncomingVoyage());
        map.put("shiftSeqN", this.vesselIdentity.getShiftSeqN());
        map.put("outVoyageNumber", this.outVoyageNumber);
        map.put("berthingTime", this.berthingTime.toString());
        map.put("departingTime",this.departingTime.toString());
        map.put("berthNumber", this.berthNumber);
        map.put("status", this.status);
        map.put("berthingTimeChangeCount",this.berthingTimeChangeCount);

        if(this.updatedBerthingTime != null){
            map.put("updatedBerthingTime", this.updatedBerthingTime.toString());
        }else{
            map.put("updatedBerthingTime", this.updatedBerthingTime);
        }
        map.put("isFavourited", isFavourited);
        map.put("isSubscribed", isSubscribed);

        return map;
    }

    public Map<String, Object> toHashedMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name", this.vesselIdentity.getName());
        map.put("incomingVoyageNumber", this.vesselIdentity.getIncomingVoyage());
        map.put("shiftSeqN", this.vesselIdentity.getShiftSeqN());
        map.put("outVoyageNumber", this.outVoyageNumber);
        map.put("berthingTime", this.berthingTime.toString());
        map.put("departingTime",this.departingTime.toString());
        map.put("berthNumber", this.berthNumber);
        map.put("status", this.status);
        map.put("berthingTimeChangeCount",this.berthingTimeChangeCount);

        if(this.updatedBerthingTime != null){
            map.put("updatedBerthingTime", this.updatedBerthingTime.toString());
        }else{
            map.put("updatedBerthingTime", this.updatedBerthingTime);
        }

        return map;
    }
}
