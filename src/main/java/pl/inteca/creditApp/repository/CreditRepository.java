package pl.inteca.creditApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.inteca.creditApp.model.Credit;

public interface CreditRepository extends JpaRepository <Credit, Long> {
}
