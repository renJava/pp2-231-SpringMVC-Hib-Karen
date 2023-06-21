package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    static final String REDIRECT_ROOT = "redirect:/";
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "listU";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createU";
    }

    @PostMapping("/user-create")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createU";
        }

        userService.add(user);
        return REDIRECT_ROOT;
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUserFromTable(@PathVariable("id") Long id) {
        userService.deleteUserFromTable(id);
        return REDIRECT_ROOT;
    }

    @PatchMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updateU";
    }

    @PatchMapping("/user-update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateU";
        }

        userService.updateUser(user);
        return REDIRECT_ROOT;
    }

}