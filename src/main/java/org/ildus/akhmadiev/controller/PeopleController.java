package org.ildus.akhmadiev.controller;

import org.ildus.akhmadiev.dao.PersonDAO;
import org.ildus.akhmadiev.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("")
    public String getPeoples(Model model) {
        List<Person> allPeople = personDAO.getAllPeople();
        model.addAttribute("people",allPeople);
        return "/people/showAllPeople";
    }

    @GetMapping("/{id}")
    public String showPeople(@PathVariable("id") Long id,Model  model) {
        Person people = personDAO.getPeople(id);
        model.addAttribute("people",people);

        return "/people/showPeople";
    }

    @GetMapping("/new")
    public String addPeople(@ModelAttribute("person") Person person) {  // Model model
//        model.addAttribute("people", new Person());
        return "/people/newPeople";
    }

    @PostMapping("")
    public String createPeople(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @ModelAttribute(value = "key",binding = false)
    public String key() {
        return "Test";
    }
}
