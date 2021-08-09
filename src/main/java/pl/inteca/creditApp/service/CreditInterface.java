package pl.inteca.creditApp.service;

import pl.inteca.creditApp.model.Credit;

import java.util.List;
import java.util.Optional;

public interface CreditInterface {

    List<Credit> all();
    void add (Credit credit);
    Optional<Credit> get(Long id);

}
