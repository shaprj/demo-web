/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.controller.admin;

import com.shaprj.spring.demoweb.model.admin.Product;
import com.shaprj.spring.demoweb.model.admin.ProductType;
import com.shaprj.spring.demoweb.service.ProductService;
import com.shaprj.spring.demoweb.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllProducts(Model model){

        List<Product> userList = productService.findAll();
        List<ProductType> productTypeList = productTypeService.findAll();
        model.addAttribute("navMenuItems", MainController.navMenuItems);
        model.addAttribute("productList", userList);
        model.addAttribute("productTypeList", productTypeList);

        return new ModelAndView("products", model.asMap());
    }

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public void createUser(@ModelAttribute("name")String name,
                           @ModelAttribute("description")String description,
                           @ModelAttribute("productTypeId")Long productTypeId,
                           @ModelAttribute("price") BigDecimal price){
        Product product = new Product(
                name,
                description,
                productTypeService.findById(productTypeId).get(),
                price);
        productService.save(product);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public void updateUser(@ModelAttribute("id")Integer id,
                           @ModelAttribute("name")String name,
                           @ModelAttribute("description")String description,
                           @ModelAttribute("productTypeId")Long productTypeId,
                           @ModelAttribute("price") BigDecimal price){
        Product product = new Product(id,
                name,
                description,
                productTypeService.findById(productTypeId).get(),
                price);
        productService.save(product);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void deleteUser(@ModelAttribute("id")Integer id){
        productService.deleteById(id.longValue());
    }

}
