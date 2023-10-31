package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;

// Add @Entity annotation
@Entity
public class Skill extends AbstractEntity {
    // Add description field
    private String description;

    // Add no-arg constructor
    public Skill() {}

    // Add public accessor methods with getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
