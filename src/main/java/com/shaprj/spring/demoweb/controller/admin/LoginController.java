package com.shaprj.spring.demoweb.controller.admin;
/*
 * Created by O.Shalaevsky on 05.03.2020
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login",  method = RequestMethod.GET)
    private String login(){
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String logout(){
        return "login";
    }

}
