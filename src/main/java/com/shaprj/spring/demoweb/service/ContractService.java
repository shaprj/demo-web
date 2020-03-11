package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {

    List<Contract> findAll();

    Contract save(Contract contract);

    void deleteById(Long id);

    Page<Contract> findPaginated(Pageable pageable, List<Contract> contracts);

}
