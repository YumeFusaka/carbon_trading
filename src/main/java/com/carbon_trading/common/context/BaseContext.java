package com.carbon_trading.common.context;

// common/context/BaseContext.java

public class BaseContext {

    public static ThreadLocal<ThreadInfo> threadLocal = new ThreadLocal<>();

    public static void setCurrentInfo(ThreadInfo threadInfo) {
        threadLocal.set(threadInfo);
    }

    public static ThreadInfo getCurrentInfo() {
        return threadLocal.get();
    }


    public static void removeCurrentInfo() {
        threadLocal.remove();
    }
}