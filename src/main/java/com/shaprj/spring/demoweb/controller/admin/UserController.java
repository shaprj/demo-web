/*
    Created by O.Shalaevsky on 25.02.2020
*/

package com.shaprj.spring.demoweb.controller.admin;

import com.shaprj.spring.demoweb.model.admin.User;
import com.shaprj.spring.demoweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/id/{userId}", method= RequestMethod.GET)
    public Optional<User> getUser(@PathVariable long userId){
        return getUserById(userId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllUsers(Model model){

        List<User> userList = userService.findAll();
        model.addAttribute("navMenuItems", MainController.navMenuItems);
        model.addAttribute("userList", userList);

        return new ModelAndView("users", model.asMap());
    }

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public void createUser(@ModelAttribute("name")String name,
                           @ModelAttribute("login")String login,
                           @ModelAttribute("age")Integer age,
                           @ModelAttribute("male")Boolean isMale){
        User user = new User(name, login, age, isMale);
        userService.save(user);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public void updateUser(@ModelAttribute("id")Integer id,
                           @ModelAttribute("name")String name,
                           @ModelAttribute("login")String login,
                           @ModelAttribute("age")Integer age,
                           @ModelAttribute("male")Boolean isMale){

        User user = new User(id, name, login, age, isMale);
        userService.save(user);

//        getUserById(id).ifPresent(user -> userService.save(user));
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void deleteUser(@ModelAttribute("id")Integer id){

        userService.deleteById(id.longValue());
    }

    private Optional<User> getUserById(long id){
        return userService.findAll()
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

}
