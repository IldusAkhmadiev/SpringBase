package org.ildus.akhmadiev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goodbye")
public class Goodbye {

    @GetMapping("")
    public String goodMain(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        model.addAttribute("hello"," hello " + name + " " + surname);
        return "goodbye/main";
    }

    @GetMapping("/good1")
    public String good(HttpServletRequest request) {
        return "goodbye/good";
    }

    @GetMapping("/good2")
    public String good2(@RequestParam(value = "name",required = false) String name,Model model) {
        System.out.println("------------- "  + name);
        return "goodbye/good2";
    }
}
