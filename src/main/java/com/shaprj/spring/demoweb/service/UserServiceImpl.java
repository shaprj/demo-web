/*
    Created by O.Shalaevsky on 25.02.2020
*/

package com.shaprj.spring.demoweb.service;

import com.shaprj.spring.demoweb.model.admin.User;
import com.shaprj.spring.demoweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {

        List<User> list = (List<User>) userRepository.findAll();

        return list;
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);

    }

    @Override
    public void deleteById(Long id) {

        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
