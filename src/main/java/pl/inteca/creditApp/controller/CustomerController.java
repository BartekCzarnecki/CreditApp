package pl.inteca.creditApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.inteca.creditApp.model.Credit;
import pl.inteca.creditApp.model.Customer;
import pl.inteca.creditApp.model.Product;
import pl.inteca.creditApp.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String customerForm (Model model) {
        model.addAttribute("customer", new Customer());
        return "CustomerForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomerForm (@ModelAttribute Customer customer, BindingResult result){
        customerService.add(customer);
        return "CreditInfo";
    }

}
