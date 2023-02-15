package org.calculator.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v1/")
public class CalculatorController {

    @GetMapping("/calculate")
    public String calculate(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model) {
        double result = 0;
        switch (action) {
            case ("multiplication") -> {
                result = a * b;
                action = " * ";
            }
            case ("addition") -> {
                result = a + b;
                action = " + ";
            }
            case ("subtraction") -> {
                result = a - b;
                action = " - ";
            }
            case ("division") -> {
                result = (double) a / b;
                action = " / ";
            }
        }
        model.addAttribute("resultMessage", a + action + b + " = " + result);
        System.out.println(result);
        return "result";
    }

}
