package pl.inteca.creditApp.service;

import pl.inteca.creditApp.model.Credit;
import pl.inteca.creditApp.repository.CreditRepository;

import java.util.List;
import java.util.Optional;

public class CreditService implements CreditInterface{

    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public List<Credit> all() {
        return creditRepository.findAll();
    }

    @Override
    public void add(Credit credit) {
        creditRepository.save(credit);
    }

    @Override
    public Optional<Credit> get(Long id) {
        return creditRepository.findById(id);
    }
}
