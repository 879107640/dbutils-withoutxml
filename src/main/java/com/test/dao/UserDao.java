package com.test.dao;

import com.test.domain.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUse(User user);

    void deleteUser(Integer id);

    User findOne(Integer id);

    List<User> findAll();
}
