package altimate.bankingApp.controller;

import altimate.bankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/view-accounts")
    public String viewAccounts(Model model) {
        model.addAttribute("account", accountService.findAll());
        return "accounts/view-accounts";
    }
}
