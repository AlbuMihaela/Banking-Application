package altimate.bankingApp.controller;

import altimate.bankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankingOperationController {

    private final AccountRepository accountRepository;

    @Autowired
    public BankingOperationController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/banking-operations")
    public String viewBankingOperationPage(Model model) {
        model.addAttribute("account", accountRepository.findAll());
        return "operations/banking-operations";
    }

}
