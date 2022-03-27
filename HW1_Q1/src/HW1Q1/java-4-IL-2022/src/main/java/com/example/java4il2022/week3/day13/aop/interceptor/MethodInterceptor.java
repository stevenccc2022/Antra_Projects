package com.example.java4il2022.week3.day13.aop.interceptor;


import com.example.java4il2022.week3.day13.aop.MethodInvocation;

public interface MethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
