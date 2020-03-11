/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.repository.crud;

import com.shaprj.spring.demoweb.model.admin.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {
}
