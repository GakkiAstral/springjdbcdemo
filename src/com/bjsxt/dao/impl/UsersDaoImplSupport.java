package com.bjsxt.dao.impl;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.pojo.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class UsersDaoImplSupport extends JdbcDaoSupport implements UsersDao {
    @Override
    public int insertUsers(Users users) {
        return 0;
    }

    @Override
    public int[] batchInsertUsers(List<Users> users) {
        return new int[0];
    }

    @Override
    public Users selectUsersById(int userid) {
        return null;
    }

    @Override
    public List<Users> selectUsersByName(String username) {
        return null;
    }

    @Override
    public List<Users> selectUsersByName2(String username) {
        String sql = "select * from users where username = ?";
        Object[] param = new Object[]{username};
        return this.getJdbcTemplate().query(sql,param,new BeanPropertyRowMapper<>(Users.class));
    }
}
