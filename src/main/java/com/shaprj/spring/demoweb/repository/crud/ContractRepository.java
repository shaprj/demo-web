package com.shaprj.spring.demoweb.repository.crud;
/*
 * Created by O.Shalaevsky on 04.03.2020
 */

import com.shaprj.spring.demoweb.model.admin.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {
}
