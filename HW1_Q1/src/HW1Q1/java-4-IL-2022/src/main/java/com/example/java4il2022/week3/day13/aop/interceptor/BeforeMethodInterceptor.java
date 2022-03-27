package com.example.java4il2022.week3.day13.aop.interceptor;

import com.example.java4il2022.week3.day13.aop.MethodInvocation;

import java.lang.reflect.Method;

public class BeforeMethodInterceptor implements MethodInterceptor{

    private Object aspectObj;
    private Method aspectMethod;

    public BeforeMethodInterceptor(Object aspectObj, Method aspectMethod) {
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation mi)  throws Throwable{
        aspectMethod.setAccessible(true);
        aspectMethod.invoke(aspectObj);
        return mi.proceed();
    }
}
