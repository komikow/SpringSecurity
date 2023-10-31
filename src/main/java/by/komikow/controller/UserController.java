package by.komikow.controller;

import by.komikow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/about")
    public String getUser(Principal principal, Model model) {
        String username = principal.getName();
        System.out.println(userService.readUser(username));
        model.addAttribute("readUser", userService.readUser(username));
        return "aboutUser";
    }
}
