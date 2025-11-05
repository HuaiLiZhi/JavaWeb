package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(10)
@Component
//@Aspect
public class MyAspect5 {
    //前置通知
//    @Before("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Before("execution(void delete(java.lang.Integer))")
//    @Before("execution(* com.*.service.impl.*.del*(..))")
//    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) ||" +
//            "execution(* com.itheima.service.impl.DeptServiceImpl.delete(..))")

    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }

}
