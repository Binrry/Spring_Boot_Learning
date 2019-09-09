package com.tyq.conmysql;

import com.tyq.conmysql.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConmysqlApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void mySqlTest()
    {
        String sql="select * from user";
        List<User> userList=jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        System.out.println("查询成功：");
        for (User user:userList)
        {
            System.out.println("【id】:"+user.getId()+";【name】:"+user.getName()+";【password】:"+user.getPassword());
        }
    }
}
