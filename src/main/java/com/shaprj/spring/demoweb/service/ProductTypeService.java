/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {

    List<ProductType> findAll();

    ProductType save(ProductType productType);

    void deleteById(Long id);

    Optional<ProductType> findById(Long id);

}
