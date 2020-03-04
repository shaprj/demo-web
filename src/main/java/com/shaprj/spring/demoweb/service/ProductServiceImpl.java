/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.Product;
import com.shaprj.spring.demoweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product save(Product user) {
        return productRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
