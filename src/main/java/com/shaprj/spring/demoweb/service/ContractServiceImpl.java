package com.shaprj.spring.demoweb.service;
/*
 * Created by O.Shalaevsky on 04.03.2020
 */

import com.shaprj.spring.demoweb.model.admin.Contract;
import com.shaprj.spring.demoweb.repository.crud.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    @Override
    public Page<Contract> findPaginated(Pageable pageable, List<Contract> contracts) {

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Contract> list;

        if (contracts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, contracts.size());
            list = contracts.subList(startItem, toIndex);
        }

        Page<Contract> contractPage = new PageImpl<Contract>(list, PageRequest.of(currentPage, pageSize), contracts.size());

        return contractPage;
    }
}
