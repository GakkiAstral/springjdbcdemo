package com.bjsxt.dao;

import com.bjsxt.pojo.Users;

import java.util.List;

public interface UsersDao {
    int insertUsers(Users users);
    int[] batchInsertUsers(List<Users> users);
    Users selectUsersById(int userid);
}
