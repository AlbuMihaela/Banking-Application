package altimate.bankingApp.service;

import altimate.bankingApp.model.Account;
import altimate.bankingApp.model.Transaction;
import altimate.bankingApp.repository.BankingOperationRepository;
import org.springframework.stereotype.Service;


@Service
public class BankingOperationService {

    Transaction transaction = new Transaction();
    private final BankingOperationRepository bankingOperationRepository;

    public BankingOperationService(BankingOperationRepository bankingOperationRepository) {
        this.bankingOperationRepository = bankingOperationRepository;
    }


    public Transaction withdraw(Integer amount, Account account) {

        if (amount <= 0) {
            System.out.println("The amount must be a positive number!!!");
        } else {
            if (account.getBalance() < amount) {
                System.out.println("Insufficient balance!");
            } else {
                transaction.setCurrentAccount(account);
                account.setBalance((int) (account.getBalance() - amount));
                transaction.setAmount(amount);
                if (transaction == null) {
                    System.out.println("Transaction failed!");
                } else {
                    System.out.println("Transaction successfully!");
                    bankingOperationRepository.save(transaction);
                }
            }
        }
        return transaction;
    }

    public Transaction deposit(Integer amount, Account account) {

        if (amount <= 0) {
            System.out.println("The amount must be a positive number!!!");
        } else {
            transaction.setCurrentAccount(account);
            account.setBalance((int) (account.getBalance() + amount));
            transaction.setAmount(amount);

            bankingOperationRepository.save(transaction);
        }
        return transaction;
    }
}
