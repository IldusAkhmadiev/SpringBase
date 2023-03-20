package org.ildus.akhmadiev.controller;

import org.ildus.akhmadiev.dao.PersonDAO;
import org.ildus.akhmadiev.models.Person;
import org.ildus.akhmadiev.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final PersonValidator validator;

    @Autowired
    public PeopleController(PersonDAO personDAO, PersonValidator validator) {
        this.personDAO = personDAO;
        this.validator = validator;
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
    public String addPeople(@ModelAttribute("person22") Person person) {  // Model model
//        model.addAttribute("people", new Person());
        return "/people/newPeople";
    }

    @PostMapping("")
    public String createPeople(@ModelAttribute("person22") @Valid Person person, BindingResult result) {
        validator.validate(person,result);
        if(result.hasErrors()) {
            return "/people/newPeople";
        }
        personDAO.save(person);
        return "redirect:/people";
    }

    // добавляет модель для всех контроллеров
    @ModelAttribute(value = "key",binding = false)
    public String key() {
        return "Test";
    }

    @GetMapping("/{id}/edit")
    public String editPeople(Model model,@PathVariable("id") int id) {
        model.addAttribute("person1",personDAO.getPeople((long) id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person1") @Valid Person person,BindingResult result,@PathVariable("id") long id) {
        validator.validate(person,result);
        if(result.hasErrors()) {
            return "/people/edit";
        }
        personDAO.update(id,person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

}
