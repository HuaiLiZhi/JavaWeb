package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect6 {

    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("before ...");

        //获取目标对象
        Object target = joinPoint.getTarget();
        log.info("target: {}", target);

        //获取目标类
        String className = joinPoint.getTarget().getClass().getName();
        log.info("className: {}", className);

        //获取目标方法
        String methodName = joinPoint.getSignature().getName();
        log.info("methodName: {}", methodName);

        //获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        log.info("args: {}", Arrays.toString(args));
    }




}
