/*
    Created by O.Shalaevsky on 26.02.2020
*/

package com.shaprj.spring.demoweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    public static Map<String, String> navMenuItems = Stream.of(
            new String[][]{
                    {"Users", "~/users"},
                    {"Products", "~/products"},
                    {"Contracts", "~/contracts"},
    }).collect(Collectors.toMap(i -> i[0], i -> i[1]));

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initIndex(Model model){
        model.addAttribute("navMenuItems", navMenuItems);
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String initUsers(Model model){
        model.addAttribute("navMenuItems", navMenuItems);
        return "redirect:users/all";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String initProducts(Model model){
        model.addAttribute("navMenuItems", navMenuItems);
        return "redirect:products/all";
    }

    @RequestMapping(value = "/contracts", method = RequestMethod.GET)
    public String initContacts(Model model){
        model.addAttribute("navMenuItems", navMenuItems);
        return "redirect:contracts/all";
    }


}
