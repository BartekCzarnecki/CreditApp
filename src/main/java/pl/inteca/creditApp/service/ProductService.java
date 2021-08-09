package pl.inteca.creditApp.service;

import org.springframework.stereotype.Service;
import pl.inteca.creditApp.model.Product;
import pl.inteca.creditApp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductInterface{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> all() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return productRepository.findById(id);
    }
}
