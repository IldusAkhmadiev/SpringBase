package org.ildus.akhamdiev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goodbye")
public class Goodbye {

    @GetMapping("")
    public String goodMain(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "goodbye/main";
    }

    @GetMapping("/good1")
    public String good(HttpServletRequest request) {
        return "goodbye/good";
    }

    @GetMapping("/good2")
    public String good2(@RequestParam("name") String name) {
        System.out.println("------------- "  + name);
        return "goodbye/good2";
    }
}
