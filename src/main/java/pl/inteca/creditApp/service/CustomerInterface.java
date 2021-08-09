package pl.inteca.creditApp.service;

import pl.inteca.creditApp.model.Credit;
import pl.inteca.creditApp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerInterface {

    List<Customer> all();
    void add (Customer customer);
    Optional<Customer> get(Long id);

}
