package pl.inteca.creditApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.inteca.creditApp.model.Credit;
import pl.inteca.creditApp.service.CreditService;
import pl.inteca.creditApp.service.CustomerService;
import pl.inteca.creditApp.service.ProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;
    private final ProductService productService;
    private final CustomerService customerService;

    public CreditController(CreditService creditService, ProductService productService, CustomerService customerService) {
        this.creditService = creditService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public String allCredits(Model model) {
        List<Credit> credits = creditService.all();
        model.addAttribute("allCredits", credits);
        return "allCredits";
    }

    @GetMapping("/show/{id}")
    public String showCredit(Model model, @PathVariable long id) {
        model.addAttribute("customer", creditService.get(id).orElseThrow(EntityNotFoundException::new));
        return "Show";
    }
}
