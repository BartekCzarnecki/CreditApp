package pl.inteca.creditApp.service;

import org.springframework.stereotype.Service;
import pl.inteca.creditApp.model.Customer;
import pl.inteca.creditApp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
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
