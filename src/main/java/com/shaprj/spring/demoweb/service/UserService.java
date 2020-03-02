/*
    Created by O.Shalaevsky on 25.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);

}
