package altimate.bankingApp.repository;

import altimate.bankingApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingOperationRepository extends JpaRepository<Transaction, Integer> {
}
