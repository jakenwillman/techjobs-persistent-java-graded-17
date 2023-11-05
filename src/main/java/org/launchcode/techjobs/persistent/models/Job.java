package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
// Update the class definition of Job to extend AbstractEntity
public class Job extends AbstractEntity {
// remove the redundant name and id fields that are being inherited from AbstractEntity
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;


//  replace the type of the field employer to be of type Employer
//  add @ManyToOne annotation to the updated field Employer
//  private String employer;
    @ManyToOne
    private Employer employer;

    // refactored skills field to be a list of Skill objects
    @ManyToMany
    private List<Skill> skills;


    public Job() {
    }

    // Initialize the id and value fields.
    // refactor affected methods from changing the employer type to Employer and skill type to List<Skill>
    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    // Getters and setters.
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    // refactored getter and setter for new Employer type
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // refactored getter and setter for new skills type
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
