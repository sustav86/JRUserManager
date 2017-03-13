package com.sustav86.usersmanager.controller;

import com.sustav86.usersmanager.maintain.UserService;
import com.sustav86.usersmanager.sample.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SUSTAVOV on 12.03.2017.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
       if (user.getId() == 0) {
           this.userService.addUser(user);
       }else {
           this.userService.updateUser(user);
       }

       return "redirect:/users";

    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        this.userService.deleteUser(id);

        return "redirect:/users";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }

    @RequestMapping(value="/userfind", method=RequestMethod.POST)
    public String searchUser(@RequestParam("findUser") String userName, Model model) {
        model.addAttribute("listUsers", this.userService.searchUser(userName));

        return "userfind";
    }
}
