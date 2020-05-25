package com.test;

import com.test.domain.User;
import com.test.service.UserService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    private AnnotationConfigApplicationContext ac;

    /*@Before
    public void init(){
        ac = new AnnotationConfigApplicationContext();
        ac.register(SpringConfiguration.class);
        //ac.register(JdbcConfig.class);
        userService = ac.getBean("userService",UserService.class);
    }*/

    @Test
    public void saveTest(){
        User user = new User();
        user.setId(2);
        user.setAge(18);
        user.setName("张三123");
        userService.saveUser(user);
    }

    @Test
    public void updateTest(){
        User user = new User();
        user.setId(1);
        user.setAge(17);
        user.setName("demo1");
        userService.updateUse(user);
    }

    @Test
    public void deleteTest(){
        userService.deleteUser(1);
    }

    @Test
    public void findOneTest(){
        User user = userService.findOne(2);
        System.out.println(user);
    }

    @Test
    public void findAll(){
        List<User> list = userService.findAll();
        list.forEach(user-> System.out.println(user));
    }

}
