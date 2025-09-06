package com.qyy.mp.service;

import com.qyy.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void test(){
        User user1 = new User();
        user1.setNickName("tatan33");
        user1.setPassword("1234");
        user1.setPhone("123321123");
        userService.save(user1);
    }

    @Test
    void test2(){
        User user = userService.getById(1L);
        System.out.println(user);

        List<User> users = userService.listByIds(List.of(1, 2, 3, 4, 5));
        users.forEach(System.out::println);
    }

    @Test
    void testSaveBatch(){
        String s = userService.deductPhoneById(1L, 200);
        System.out.println(s);
    }
}