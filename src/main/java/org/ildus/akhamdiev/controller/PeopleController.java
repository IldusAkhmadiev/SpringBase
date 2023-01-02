package org.ildus.akhamdiev.controller;

import org.ildus.akhamdiev.dao.PersonDAO;
import org.ildus.akhamdiev.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
