package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// copied over EmployerController and modified routing and methods to use data for skills instead of employers
@Controller
@RequestMapping("skills")
public class SkillController {
    // give the skillRepository field an @Autowired annotation
    @Autowired

    // Add private field of SkillRepository type called skillRepository
    private SkillRepository skillRepository;

    // Add an index method that responds at /skills
    @GetMapping("/")
    public String index(Model model) {
        // pass skills into the view using model.addAttribute to show a list of all skills in the database with findAll() method
        model.addAttribute("skills", skillRepository.findAll());
        // this method should use the template skills/index
        return "skills/index";
    }

    // copied the displayAddEmployerForm method from EmployerController, renamed it displayAddSkillForm and changed the model attribute to create a new Skill object instead of Employer
    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        // changed routing to /skills/add instead of /employers/add
        return "skills/add";
    }
    // copied the processAddSkillForm method from EmployerController, renamed it processAddSkillForm and changed all the previous Employer data to Skills
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        }
        // add a method to save a valid employer object using the newSkill object
        skillRepository.save(newSkill);
        return "redirect:";
    }

    // copied the displayViewEmployer method from EmployerController, renamed it displayViewSkill and changed all the previous Employer data to Skills
    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        Optional<Skill> optSkills = skillRepository.findById(skillId);
        if (optSkills.isPresent()) {
            Skill skills = optSkills.get();
            model.addAttribute("skill", skills);
            return "skills/view";
        } else {
            return "redirect:../";
        }

    }
}
