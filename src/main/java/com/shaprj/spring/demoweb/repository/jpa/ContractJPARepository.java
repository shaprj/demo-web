/*
    Created by O.Shalaevsky on 11.03.2020
*/

package com.shaprj.spring.demoweb.repository.jpa;

import com.shaprj.spring.demoweb.model.admin.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContractJPARepository extends JpaRepository<Contract, Long>, JpaSpecificationExecutor<Contract> {
}
