package com.bjsxt.service.impl;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    /**
     * 添加用户
     * @param users
     * @return
     */
    @Override
    public int addUsers(Users users) {
        return this.usersDao.insertUsers(users);
    }

    /**
     * 批量添加用户
     * @param users
     * @return
     */
    @Override
    public int[] addUsers(List<Users> users) {
        return this.usersDao.batchInsertUsers(users);
    }

    /**
     * 根据id查询用户
     * @param userid
     * @return
     */
    @Override
    public Users findUsersById(int userid) {
        return this.usersDao.selectUsersById(userid);
    }
}
