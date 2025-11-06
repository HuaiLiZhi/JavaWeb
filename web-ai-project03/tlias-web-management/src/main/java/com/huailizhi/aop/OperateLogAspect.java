package com.huailizhi.aop;

import com.huailizhi.mapper.OperateLogMapper;
import com.huailizhi.pojo.OperateLog;
import com.huailizhi.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.huailizhi.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long beginTime = System.currentTimeMillis();
        
        // 获取目标方法的详细信息
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String methodParams = Arrays.toString(joinPoint.getArgs());
        
        // 限制参数和返回值的长度
        if (methodParams.length() > 2000) {
            methodParams = methodParams.substring(0, 2000);
        }
        
        Object result = null;
        try {
            // 执行目标方法
            result = joinPoint.proceed();
            return result;
        } finally {
            // 记录结束时间
            long endTime = System.currentTimeMillis();
            long costTime = endTime - beginTime;
            
            // 获取返回值字符串
            String returnValue = result != null ? result.toString() : "";
            if (returnValue.length() > 2000) {
                returnValue = returnValue.substring(0, 2000);
            }
            
            // 获取操作人ID
            Integer operateEmpId = getCurrentOperateEmpId();
            
            // 创建操作日志对象
            OperateLog logPojo = new OperateLog();
            logPojo.setOperateEmpId(operateEmpId);
            logPojo.setOperateTime(LocalDateTime.now());
            logPojo.setClassName(className);
            logPojo.setMethodName(methodName);
            logPojo.setMethodParams(methodParams);
            logPojo.setReturnValue(returnValue);
            logPojo.setCostTime(costTime);
            
            // 保存日志到数据库
            operateLogMapper.insert(logPojo);
            
            log.info("记录操作日志: 类名={}, 方法名={}, 耗时={}ms", className, methodName, costTime);
        }
    }
    
    /**
     * 从ThreadLocal中获取当前操作人ID
     * @return 操作人ID
     */
    private Integer getCurrentOperateEmpId() {
        try {
            return BaseContext.getCurrentId();
        } catch (Exception e) {
            log.error("获取操作人ID失败", e);
        }
        return null;
    }
}