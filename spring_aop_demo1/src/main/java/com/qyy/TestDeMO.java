package com.qyy;


import com.qyy.config.SpringConfig;
import com.qyy.dao.Dao1;
import com.qyy.dao.PasswordService;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDeMO {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Dao1 dao1 = ctx.getBean(Dao1.class);
//        dao1.save();
//        dao1.update();
        PasswordService password = ctx.getBean(PasswordService.class);
//
        boolean res = password.readResource("mypassword   ");
        System.out.println(res);
    }
}
