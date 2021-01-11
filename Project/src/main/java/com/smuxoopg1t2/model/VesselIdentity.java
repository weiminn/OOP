package com.smuxoopg1t2.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Embeddable annotation Represents a composite primary key in Spring Data
 */
@Embeddable
public class VesselIdentity implements Serializable {
    private String name;
    private String incomingVoyage;
    private String shiftSeqN;

    /**
     * Constructs a Default Vessel Identity object
     */
    public VesselIdentity() {
    }

    /**
     * Constructs a specific Vessel object
     *
     * @param name           the vessel's short name (abbrVslM)
     * @param incomingVoyage the vessel's incoming voyage number (inVoyN)
     * @param shiftSeqN      the vessel's berthing sequence (shiftSeqN)
     */
    public VesselIdentity(String name, String incomingVoyage,
                          String shiftSeqN) {
        this.name = name;
        this.incomingVoyage = incomingVoyage;
        this.shiftSeqN = shiftSeqN;
    }

    /**
     * Gets the vessel's short name (abbrVslM)
     *
     * @return the vessel's short name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the vessel's incoming voyage number (inVoyN)
     *
     * @return the vessel's incoming voyage number
     */
    public String getIncomingVoyage() {
        return incomingVoyage;
    }

    /**
     * Gets the vessel's berthing sequence number (shiftSeqN)
     *
     * @return the vessel's berthing sequence number
     */
    public String getShiftSeqN() {
        return shiftSeqN;
    }

    /**
     * Sets the vessel's short name (abbrVslM)
     *
     * @param name the vessel's short name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the vessel's incoming voyage number (inVoyN)
     *
     * @param incomingVoyage the vessel's incoming voyage number (inVoyN)
     */
    public void setIncomingVoyage(String incomingVoyage) {
        this.incomingVoyage = incomingVoyage;
    }

    /**
     * Sets the vessel's berthing sequence number (shiftSeqN)
     *
     * @param shiftSeqN the vessel's berthing sequence number (shiftSeqN)
     */
    public void setShiftSeqN(String shiftSeqN) {
        this.shiftSeqN = shiftSeqN;
    }
}
