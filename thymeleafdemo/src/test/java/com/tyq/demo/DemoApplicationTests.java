package com.tyq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    private UserService userService;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testRepository()
    {
        List<User> userList=userService.findAll();
        System.out.println("findAll():"+userList.size());

        List<User> userList1=userService.findByName("张三");
        System.out.println("findByName():"+userList1.size());
        Assert.isTrue(userList1.get(0).getName().equals("张三"),"findByName() data error!");

        List<User> userList2=userService.findByNameLike("%三%");
        System.out.println("findByNameLike():"+userList2.size());
        Assert.isTrue(userList2.get(0).getName().equals("张三"),"findByNameLike() data error!");

        List<String> ids=new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        List<User> userList3=userService.findByIdIn(ids);
        System.out.println("findByIdIn():"+userList3.size());

        PageRequest pageRequest=new PageRequest(0,10);
        Page<User> userList4=userService.findAll(pageRequest);
        System.out.println("page findAll():"+userList4.getTotalPages()+"/"+userList4.getSize());

        User user=new User();
        user.setId("3");
        user.setName("王五");
        user.setPassword("123456");
        userService.save(user);
        System.out.println("save():[id]:"+user.getId()+" [name]:"+user.getName()+" [password]:"+user.getPassword());

        User user1=new User();
        user1.setId("4");
        user1.setName("赵六");
        user1.setPassword("123456");
        userService.save(user1);
        System.out.println("save():[id]:"+user1.getId()+" [name]:"+user1.getName()+" [password]:"+user1.getPassword());

        List<User> userList0=userService.findAll();
        System.out.println("findAll():"+userList0.size());

        userService.delete("4");
        System.out.println("delete():[id]:4");


        List<User> userList10=userService.findAll();
        System.out.println("findAll():"+userList10.size());
    }

}
