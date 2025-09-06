package com.qyy.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qyy.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.sql.Wrapper;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectById() {
        // This is a placeholder for the actual test code.
        System.out.println(userMapper);
        User user = userMapper.selectById(4);
        System.out.println(user);
    }

    @Test
    void testInsertUser(){
        User user1 = new User();
        user1.setNickName("John Doe");
        user1.setPhone("1234567890");
        user1.setPassword("1234");
        userMapper.insert(user1);
    }

    @Test
    void testQueryWrapper(){
        // 构造查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("nick_name", "phone")
                .like("nick_name", "John");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void testLambdaQueryWrapper(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId,User::getNickName, User::getPhone,User::getPassword)
                .like(User::getNickName, "tatan");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
}
