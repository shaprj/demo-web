package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> findAll();

    Contract save(Contract contract);

    void deleteById(Long id);

}
