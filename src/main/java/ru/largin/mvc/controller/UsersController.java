package ru.largin.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.largin.mvc.model.User;
import ru.largin.mvc.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/create")
    public String getNewUserPage(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUserById(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userCard";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update(
            @ModelAttribute("person") User user,
            @PathVariable("id") int id
    ) {
        userService.updateUserById(id, user);
        return "redirect:/users";
    }
}
