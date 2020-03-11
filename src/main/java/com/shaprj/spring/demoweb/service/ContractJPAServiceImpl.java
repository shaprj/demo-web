/*
    Created by O.Shalaevsky on 11.03.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.Contract;
import com.shaprj.spring.demoweb.repository.jpa.ContractJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractJPAServiceImpl implements ContractJPAService {

    @Autowired
    private ContractJPARepository contractJPARepository;

    @Override
    public List<Contract> findAll(Specification<Contract> specification) {

        return contractJPARepository.findAll(specification);

    }
}
