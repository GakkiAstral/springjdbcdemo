package com.bjsxt.dao.impl;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.pojo.Users;
import org.springframework.jdbc.core.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 添加用户
     * @param users
     * @return
     */
    @Override
    public int insertUsers(Users users) {
        String sql = "insert into users values(default,?,?)";
        Object[] parma = new Object[]{users.getUsername(),users.getUsersex()};
        return this.jdbcTemplate.update(sql,parma);
    }

    /**
     * 批量添加数据
     * @param users
     * @return
     */
    @Override
    public int[] batchInsertUsers(List<Users> users) {
        String sql = "insert into users values(default,?,?)";
        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Users temp = users.get(i);
                preparedStatement.setString(1,temp.getUsername());
                preparedStatement.setString(2,temp.getUsersex());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        };
        return this.jdbcTemplate.batchUpdate(sql,setter);
    }

    /**
     * 根据id查询用户
     * @param userid
     * @return
     */
    @Override
    public Users selectUsersById(int userid) {
        String sql = "select * from users where userid = ?";
        Object[] param = new Object[]{userid};
        Users users = new Users();
        this.jdbcTemplate.query(sql, param, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                //自定义是映射到哪个实体
                users.setUserid(resultSet.getInt("userid"));
                users.setUsername(resultSet.getString("username"));
                users.setUsersex(resultSet.getString("usersex"));
            }
        });
        return users;
    }

    /**
     * 根据用户姓名，查询返回多条数据。
     * @param username
     * @return
     */
    @Override
    public List<Users> selectUsersByName(String username) {
        String sql = "select * from users where username = ?";
        Object[] param = new Object[]{username};
        return this.jdbcTemplate.query(sql, param, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users users = new Users();
                users.setUserid(resultSet.getInt("userid"));
                users.setUsername(resultSet.getString("username"));
                users.setUsersex(resultSet.getString("usersex"));
                return users;
            }
        });
    }

    @Override
    public List<Users> selectUsersByName2(String username) {
        String sql = "select * from users where username = ?";
        Object[] param = new Object[]{username};
        return this.jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<>(Users.class));
    }
}
