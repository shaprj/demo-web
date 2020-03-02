/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);

}
