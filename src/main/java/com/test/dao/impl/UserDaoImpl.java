package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private QueryRunner runner;

    /*public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }*/

    public void saveUser(User user){
        try {
            runner.update(" insert into user(id,age,name) values(?,?,?) ",user.getId(),user.getAge(),user.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUse(User user) {
        try {
            runner.update(" UPDATE USER SET AGE = ?,NAME = ? WHERE ID = ? ",user.getAge(),user.getName(),user.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUser(Integer id) {
        try {
            runner.update(" DELETE FROM USER WHERE ID = ? ",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User findOne(Integer id) {
        User user = null ;
        try {
            user = runner.query(" SELECT * FROM USER WHERE ID = ? ",new BeanHandler<User>(User.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try {
            list = runner.query(" SELECT * FROM USER ",new BeanListHandler<User>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
