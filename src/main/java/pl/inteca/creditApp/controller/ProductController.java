package pl.inteca.creditApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.inteca.creditApp.model.Product;
import pl.inteca.creditApp.service.ProductService;

import javax.persistence.EntityNotFoundException;

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
        return "Next";
    }

    @GetMapping("/show/{id}")
    public String showProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.get(id).orElseThrow(EntityNotFoundException::new));
        return "Show";
    }
}
