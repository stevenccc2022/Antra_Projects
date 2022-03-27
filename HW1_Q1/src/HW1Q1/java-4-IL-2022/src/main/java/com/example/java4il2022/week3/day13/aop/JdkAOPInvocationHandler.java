package com.example.java4il2022.week3.day13.aop;


import com.example.java4il2022.week3.day13.aop.advice.After;
import com.example.java4il2022.week3.day13.aop.advice.Around;
import com.example.java4il2022.week3.day13.aop.advice.Before;
import com.example.java4il2022.week3.day13.aop.interceptor.AfterMethodInterceptor;
import com.example.java4il2022.week3.day13.aop.interceptor.AroundMethodInterceptor;
import com.example.java4il2022.week3.day13.aop.interceptor.BeforeMethodInterceptor;
import com.example.java4il2022.week3.day13.aop.interceptor.MethodInterceptor;
import org.springframework.aop.framework.AdvisedSupport;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JdkAOPInvocationHandler implements InvocationHandler {

    private Object originObj;
    private Object aspectObj;

    public JdkAOPInvocationHandler(Object originObj, Object aspectObj) {
        this.originObj = originObj;
        this.aspectObj = aspectObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> aspectClass = aspectObj.getClass();
        List<MethodInterceptor> interceptors = new ArrayList<>();
        for(Method aspectMethod: aspectClass.getDeclaredMethods()) {
            for(Annotation ano: aspectMethod.getDeclaredAnnotations()) {
                MethodInterceptor methodInterceptor = null;
                if(ano.annotationType() == Before.class) {
                    methodInterceptor = new BeforeMethodInterceptor(aspectObj, aspectMethod);
                } else if(ano.annotationType() == After.class) {
                    methodInterceptor = new AfterMethodInterceptor(aspectObj, aspectMethod);
                } else if(ano.annotationType() == Around.class) {
                    methodInterceptor = new AroundMethodInterceptor(aspectObj, aspectMethod);
                }
                interceptors.add(methodInterceptor);
            }
        }
        MethodInvocation mi = new ProxyMethodInvocation(interceptors, originObj, method, args);
        return mi.proceed();
    }
}