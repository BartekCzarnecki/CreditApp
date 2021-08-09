package pl.inteca.creditApp.service;

import pl.inteca.creditApp.model.Credit;
import pl.inteca.creditApp.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInterface {

    List<Product> all();
    void add (Product product);
    Optional<Product> get(Long id);

}
