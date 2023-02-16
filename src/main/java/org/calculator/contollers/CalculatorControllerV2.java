package org.calculator.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v2")
public class CalculatorControllerV2 {
    @GetMapping("/calculate")
    public String showCalculator() {
        return "calculator-v2";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam(value="a", required = false) Integer a, @RequestParam(value="b", required = false) Integer b,
                            @RequestParam(value="action", required = false) String action, Model model) {
        if(a == null || b == null || action == null)
            return "calculator-v2";

        double result;
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
            default -> result = 0;
        }
        model.addAttribute("resultMessage", a + action + b + " = " + result);
        return "result-v2";
    }
}
