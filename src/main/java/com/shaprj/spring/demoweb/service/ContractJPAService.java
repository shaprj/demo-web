/*
    Created by O.Shalaevsky on 11.03.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.Contract;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContractJPAService {

    List<Contract> findAll(Specification<Contract> specification);

}
