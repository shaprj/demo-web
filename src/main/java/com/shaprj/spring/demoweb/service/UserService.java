/*
    Created by O.Shalaevsky on 25.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);

    Optional<User> findById(Long var1);

}
