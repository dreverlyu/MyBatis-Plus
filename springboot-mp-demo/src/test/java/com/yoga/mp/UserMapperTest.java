package com.yoga.mp;

import com.yoga.mp.mapper.UserMapper;
import com.yoga.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.dc.pr.PRError;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Test
    public  void  testSelect(){
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList.toString());
    }
    @Test
    public void testFindById(){
        User userMapperById = userMapper.findById(1L);
        System.out.println(userMapperById.toString());
    }
}
