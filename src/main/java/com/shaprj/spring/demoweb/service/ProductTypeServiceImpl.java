/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.ProductType;
import com.shaprj.spring.demoweb.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return (List<ProductType>) productTypeRepository.findAll();
    }

    @Override
    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public void deleteById(Long id) {
        productTypeRepository.deleteById(id);
    }

    @Override
    public Optional<ProductType> findById(Long id){
        return productTypeRepository.findById(id);
    }
}
