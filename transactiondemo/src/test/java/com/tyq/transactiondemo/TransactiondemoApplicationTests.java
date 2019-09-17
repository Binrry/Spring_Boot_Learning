package com.tyq.transactiondemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactiondemoApplicationTests {

    @Resource
    private UserService userService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testTransaction()
    {
        List<User> userList=userService.findAll();
        System.out.println("findAll():"+userList.size());
        User user=new User();
        user.setId("8");
        user.setName("冰蕊");
        user.setPassword("Binrry");
        userService.save(user);
        System.out.println("save():[id]:"+user.getId()+" [name]:"+user.getName()+" [password]:"+user.getPassword());
        List<User> userList1=userService.findAll();
        System.out.println("findAll():"+userList1.size());
    }

}
