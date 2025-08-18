package com.qyy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
// 表示将该类作为AOP去执行 也就是说定义了一个切面
@Aspect
public class MyAdvice {

    // 定义一个切入点,指定当什么时候执行该aop方法
    @Pointcut("execution( void com.qyy.dao.Dao1.update())")
    public void pt() {
    }

    @Pointcut("execution(boolean com.qyy.dao.PasswordService.readResource(*))")
    public void pt2() {}

    // 可以定义 在切点前或者后 又或者环绕通知
    @Before("pt()")
    public void before() {
        System.out.println("执行我的AOP方法");
        System.out.println(System.currentTimeMillis());
    }

    @After("pt()")
    public void after() {
        System.out.println("执行我的AOP方法结束");
        System.out.println(System.currentTimeMillis());
    }
    @Around("pt()")
    // procedingJoinPoint 是一个切入点对象
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("执行我的AOP方法环绕开始");
        // 表示对原始操作的调用
        pjp.proceed();// 也就是表示 当原始方法执行后
        System.out.println("执行我的AOP方法环绕结束");
    }


    @Around("pt2()")
    public Object changePassword(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for(int i=0;i<args.length;i++){
            if(args[i] instanceof String){
                args[i] = ((String) args[i]).trim();
            }
        }
        return pjp.proceed(args);
    }
}
