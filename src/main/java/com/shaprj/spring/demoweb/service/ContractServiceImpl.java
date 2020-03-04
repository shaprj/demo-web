package com.shaprj.spring.demoweb.service;
/*
 * Created by O.Shalaevsky on 04.03.2020
 */

import com.shaprj.spring.demoweb.model.admin.Contract;
import com.shaprj.spring.demoweb.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
