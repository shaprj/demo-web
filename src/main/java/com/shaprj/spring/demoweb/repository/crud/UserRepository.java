/*
    Created by O.Shalaevsky on 25.02.2020
*/

package com.shaprj.spring.demoweb.repository.crud;

import com.shaprj.spring.demoweb.model.admin.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
