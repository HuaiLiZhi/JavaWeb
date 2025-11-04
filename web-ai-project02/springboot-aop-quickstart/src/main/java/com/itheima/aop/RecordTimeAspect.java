package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect // 表示当前类是一个切面类
@Slf4j
public class RecordTimeAspect {

    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        // 记录方法运行的开始时间
        long begin = System.currentTimeMillis();

        // 运行方法
        Object result = pjp.proceed();


        // 记录方法运行的结束时间
        long end = System.currentTimeMillis();
        log.info("方法运行耗时：{}ms", end - begin);

        return result;
    }
}
