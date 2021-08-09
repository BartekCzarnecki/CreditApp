package pl.inteca.creditApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.inteca.creditApp.model.Product;
import pl.inteca.creditApp.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String productForm (Model model) {
        model.addAttribute("product", new Product());
        return "ProductForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProductForm (@ModelAttribute Product product, BindingResult result){
        productService.add(product);
        return "redirect:/customer/add";
    }
}
