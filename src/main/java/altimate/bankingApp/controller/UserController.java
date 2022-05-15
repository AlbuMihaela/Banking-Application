package altimate.bankingApp.controller;

import altimate.bankingApp.model.User;
import altimate.bankingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String getSelectionPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "selection/user";
    }

    @PostMapping(value = "/user")
    public String makeSelection(@ModelAttribute("user") User user) {
        user.setClientId(user.getClientId());
        return "redirect:/view-accounts";
    }
}
