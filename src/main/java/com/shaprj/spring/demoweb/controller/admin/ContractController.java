package com.shaprj.spring.demoweb.controller.admin;
/*
 * Created by O.Shalaevsky on 04.03.2020
 */

import com.shaprj.spring.demoweb.model.admin.Contract;
import com.shaprj.spring.demoweb.model.admin.Product;
import com.shaprj.spring.demoweb.model.admin.User;
import com.shaprj.spring.demoweb.service.ContractService;
import com.shaprj.spring.demoweb.service.ProductService;
import com.shaprj.spring.demoweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private ModelAndView getAll(Model model){

        setContractsModel(model);

        return new ModelAndView("contracts", model.asMap());
    }

    @RequestMapping(value = "/all/filtered", method = RequestMethod.GET)
    private ModelAndView getAllFiltered(Model model,
                                        @RequestParam String filter){

        setContractsModel(model);

        return new ModelAndView("contracts", model.asMap());
    }

    @RequestMapping(value = "/all/filtered", method = RequestMethod.POST)
    private ModelAndView getAllFilteredPost(Model model,
                                            @ModelAttribute("filter") String filter,
                                            @ModelAttribute("_csrf") String _csrf){

        setContractsModel(model);

        return new ModelAndView("contracts", model.asMap());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private void createContract(@ModelAttribute("start_date") String startDateTime,
                                @ModelAttribute("end_date") String endDateTime,
                                @ModelAttribute("user") Long userId,
                                @ModelAttribute("product") Long productId){

        User user = userService.findById(userId).orElseThrow();
        Product product = productService.findById(productId).orElseThrow();

        LocalDate localDateStart = LocalDate.parse(startDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDateEnd = LocalDate.parse(endDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Contract contract = new Contract(localDateStart, localDateEnd, user, product);
        contractService.save(contract);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private void updateContract(@ModelAttribute("id") Long id,
                                @ModelAttribute("start_date") String startDateTime,
                                @ModelAttribute("end_date") String endDateTime,
                                @ModelAttribute("user") Long userId,
                                @ModelAttribute("product") Long productId){

        User user = userService.findById(userId).orElseThrow();
        Product product = productService.findById(productId).orElseThrow();

        LocalDate localDateStart = LocalDate.parse(startDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDateEnd = LocalDate.parse(endDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Contract contract = new Contract(id, localDateStart, localDateEnd, user, product);
        contractService.save(contract);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private void deleteContract(@ModelAttribute("id") Long id){
        contractService.deleteById(id);
    }

    private void setContractsModel(Model model){

        List<Contract> contractList = contractService.findAll();
        List<User> userList = userService.findAll();
        List<Product> productList = productService.findAll();

        model.addAttribute("navMenuItems", MainController.navMenuItems);
        model.addAttribute("contractList", contractList);
        model.addAttribute("userList", userList);
        model.addAttribute("productList", productList);

    }

}
