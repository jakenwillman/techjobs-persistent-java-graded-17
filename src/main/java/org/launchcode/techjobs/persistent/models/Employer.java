package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Add the @Entity annotation
@Entity
public class Employer extends AbstractEntity {
    // Add the field for location with validation that ensures it is not empty and has reasonable length
    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    // Add no argument constructor for hibernate to create an object
    public Employer() {}

    // Add public accessor method by adding getter and setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
