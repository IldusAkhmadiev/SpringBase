package org.ildus.akhmadiev.controller;

import org.ildus.akhmadiev.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch")
public class BatchController {

    private PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("")
    public String index() {
        return "/batch/index";
    }

    @GetMapping("/without")
    public String without() {
        personDAO.withoutBatch();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String with() {
        personDAO.withBatch();
        return "redirect:/people";
    }

}
