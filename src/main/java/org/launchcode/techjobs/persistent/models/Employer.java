package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

// Add the @Entity annotation
@Entity
public class Employer extends AbstractEntity {
    // Add the field for location with validation that ensures it is not empty and has reasonable length
    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    // use @OneToMany and @JoinColumn annotations on the job list to declare the relationship between data tables
    @OneToMany
    // add a name parameter to the @JoinColumn annotation
    // had to reference the test in TestTaskThree for this method to determine which value to use for name
    @JoinColumn(name = "employer_id")
    // add a private property "jobs" of type List<Job> and initialize it to an empty array list
    private List<Job> jobs = new ArrayList<>();

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
