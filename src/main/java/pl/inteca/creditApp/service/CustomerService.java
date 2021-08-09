package pl.inteca.creditApp.service;

import pl.inteca.creditApp.model.Customer;
import pl.inteca.creditApp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService implements CustomerInterface{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> all() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> get(Long id) {
        return customerRepository.findById(id);
    }
}
