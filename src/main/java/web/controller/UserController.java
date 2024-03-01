package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @GetMapping("/new")
    public String addNewUser (Model model) {
        model.addAttribute("user", new User());
        return "UsersInfo";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute ("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "UsersInfo";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String showUsers (Model model) {
        List <User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "ShowAllUsers";
    }

    @GetMapping("/delete")
    public String deleteUserFrom (Model model,@RequestParam("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "DeleteUser";
    }

    @PostMapping("/delete")
    public String deleteUser (@RequestParam ("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUserFrom (@RequestParam ("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "UpdateUser";
    }

    @PostMapping("/update")
    public String updateUSer (@ModelAttribute("user") @Valid User UpdateUser, BindingResult bindingResult) {
        userService.updateUser(UpdateUser);
        if (bindingResult.hasErrors()) {
            return "UpdateUser";
        }
        return "redirect:/users";
    }






 }
