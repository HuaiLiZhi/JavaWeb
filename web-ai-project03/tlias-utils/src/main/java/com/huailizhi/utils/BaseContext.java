package com.huailizhi.utils;

import com.huailizhi.pojo.LogInfo;

/**
 * 基于ThreadLocal封装的工具类，用于存储和获取当前登录用户的信息
 */
public class BaseContext {
    private static ThreadLocal<LogInfo> threadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程的用户信息
     * @param logInfo 用户信息
     */
    public static void setCurrentLogInfo(LogInfo logInfo) {
        threadLocal.set(logInfo);
    }

    /**
     * 获取当前线程的用户信息
     * @return 用户信息
     */
    public static LogInfo getCurrentLogInfo() {
        return threadLocal.get();
    }

    /**
     * 获取当前线程的用户ID
     * @return 用户ID
     */
    public static Integer getCurrentId() {
        LogInfo logInfo = threadLocal.get();
        return logInfo != null ? logInfo.getId() : null;
    }

    /**
     * 清除当前线程的用户信息
     */
    public static void removeCurrentLogInfo() {
        threadLocal.remove();
    }
}