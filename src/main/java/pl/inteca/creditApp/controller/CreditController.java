package pl.inteca.creditApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.inteca.creditApp.model.Credit;
import pl.inteca.creditApp.service.CreditService;

import java.util.List;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/all")
    public String allCredits (Model model) {
        List<Credit> credits = creditService.all();
        model.addAttribute("allCredits", credits);
        return "allCredits";
    }

}
