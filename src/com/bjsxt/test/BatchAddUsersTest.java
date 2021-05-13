package com.bjsxt.test;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BatchAddUsersTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        Users users = new Users();
        users.setUsername("suibian1");
        users.setUsersex("male1");
        Users users1 = new Users();
        users1.setUsername("suibian2");
        users1.setUsersex("male1");
        List<Users> list = new ArrayList<>();
        list.add(users);
        list.add(users1);
        usersService.addUsers(list);
    }
}
