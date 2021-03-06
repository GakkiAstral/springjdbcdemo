package com.bjsxt.service;

import com.bjsxt.pojo.Users;

import java.util.List;

public interface UsersService {
    int addUsers(Users users);
    int[] addUsers(List<Users> users);
    Users findUsersById(int userid);
    List<Users> findUsersByName(String username);
    List<Users> findUsersByName2(String username);

}
