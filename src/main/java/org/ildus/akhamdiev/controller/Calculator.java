package org.ildus.akhamdiev.controller;

import org.ildus.akhamdiev.enums.CalculatorEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Controller
public class Calculator {

    @GetMapping("/calcutator")
    public String calculate(@RequestParam String first, @RequestParam String second, @RequestParam String action, Model model,
                            HttpServletRequest request, HttpServletResponse response){
//        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.setContentType("text/html;charset=UTF-8");
        CalculatorEnum actionEnum = CalculatorEnum.valueOf(action.toUpperCase(Locale.ROOT));
        Double firstDouble = new Double(first);
        Double secondDouble = new Double(second);
        switch (actionEnum) {
            case ADDITION:
                model.addAttribute("result",CalculatorEnum.ADDITION.action(firstDouble,secondDouble));
                break;
            case DIVISION:
                model.addAttribute("result",CalculatorEnum.DIVISION.action(firstDouble, secondDouble));
                break;
            case SUBTRACTION:
                model.addAttribute("result",CalculatorEnum.SUBTRACTION.action(firstDouble, secondDouble));
                break;
            case MULTIPLICATION:
                model.addAttribute("result",CalculatorEnum.MULTIPLICATION.action(firstDouble, secondDouble));
                break;
            default:
                throw new RuntimeException("-----------------Calculator exception---------------");
        }

        return "/calculator/calculator";
        }

}
