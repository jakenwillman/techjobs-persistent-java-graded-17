package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    // Add a employerRepository field annotated with @Autowired
    @Autowired
    private EmployerRepository employerRepository;

    // Add a skillRepository field annotated with @Autowired
    @Autowired
    private SkillRepository skillRepository;

    // Add a jobRepository field annotated with @Autowired
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        // Added code to pass employer data from employerRepository
        model.addAttribute("employers", employerRepository.findAll());
        // Added code to pass skills data from skillRepository
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    // Pass in selected skills from the form and pass them as a List of Integer values by using the @RequestParam annotation with the name "skills"
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        // retrieve the selected employer using the employerRepository
        Employer employer = employerRepository.findById(employerId).orElse(new Employer());
        // retrieve the selected skills using the skillRepository
        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        // set the selected employer for the job
        newJob.setEmployer(employer);
        // set the selected skills for the job
        newJob.setSkills(skillObjs);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            return "view";
    }

}
