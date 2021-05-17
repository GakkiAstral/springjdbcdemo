package com.bjsxt.dao;

import com.bjsxt.pojo.Users;

import java.util.List;

public interface UsersDao {
    int insertUsers(Users users);
    int[] batchInsertUsers(List<Users> users);
    Users selectUsersById(int userid);
    List<Users> selectUsersByName(String username);
    List<Users> selectUsersByName2(String username);
}
