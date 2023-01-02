package org.ildus.akhmadiev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello/hello_world";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello/hello2";
    }

    @GetMapping("/hello3/")
    public String hello3() {
        return "hello/hello3";
    }

//    @RequestMapping(name = "/hello4/",method = RequestMethod.GET)
//    public String hello4() {
//        return "hello/hello4";
//    }
//
//    @RequestMapping(name = "/hello5",method = RequestMethod.GET)
//    public String hello5() {
//        return "hello/hello5";
//    }
}
