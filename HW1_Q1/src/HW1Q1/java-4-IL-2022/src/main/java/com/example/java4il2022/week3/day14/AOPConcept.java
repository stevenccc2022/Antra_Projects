package com.example.java4il2022.week3.day14;

import com.example.java4il2022.week3.day13.aop.JdkAOPInvocationHandler;
import com.example.java4il2022.week3.day13.aop.MethodInvocation;
import com.example.java4il2022.week3.day13.aop.advice.After;
import com.example.java4il2022.week3.day13.aop.advice.Around;
import com.example.java4il2022.week3.day13.aop.advice.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
interface Day14StudentService {
    void printName();
}
class Day14StudentServiceImpl implements Day14StudentService{
    public void printName() {
        System.out.println("Tom");
    }
}

class Day14Aspect {
    @Around
    public Object printAround2(MethodInvocation mi) throws Throwable{
        System.out.println("before around - 2");
        Object res = mi.proceed();
        System.out.println("after around - 2");
        return res;
    }
    @After
    public void printAfter1() {
        System.out.println("after - 1");
    }
    @After
    public void printAfter2() {
        System.out.println("after - 2");
    }
    @Before
    public void printBefore1() {
        System.out.println("before - 1");
    }
    @Before
    public void printBefore2() {
        System.out.println("before - 2");
    }
    @Around
    public Object printAround1(MethodInvocation mi) throws Throwable{
        System.out.println("before around - 1");
        Object res = mi.proceed();
        System.out.println("after around - 1");
        return res;
    }
}
class Day14StudentServiceInvocationHandler implements InvocationHandler {
    private final Day14StudentService day14StudentService;
    private final Day14Aspect day14Aspect;

    public Day14StudentServiceInvocationHandler(Day14StudentService day14StudentService, Day14Aspect day14Aspect) {
        this.day14StudentService = day14StudentService;
        this.day14Aspect = day14Aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method[] methods = day14Aspect.getClass().getDeclaredMethods();
        List<Method> beforeLogic = new ArrayList<>();
        List<Method> afterLogic = new ArrayList<>();
        for(Method m: methods) {
            Annotation[] annotations = m.getDeclaredAnnotations();
            for(Annotation ano: annotations) {
                if(ano.annotationType() == Before.class) {
                    beforeLogic.add(m);
                } else if(ano.annotationType() == After.class) {
                    afterLogic.add(m);
                }
            }
        }
        for(Method m: beforeLogic) {
            m.invoke(day14Aspect);
        }
        Object res = method.invoke(day14StudentService, args);
        for(Method m: afterLogic) {
            m.invoke(day14Aspect);
        }
        return res;
    }
}

class Day14Test {
    public static void main(String[] args) {
        Day14StudentService studentService = (Day14StudentService) Proxy.newProxyInstance(
                Day14Test.class.getClassLoader(),
                new Class[]{Day14StudentService.class},
                new JdkAOPInvocationHandler(
                        new Day14StudentServiceImpl(),
                        new Day14Aspect()
                )
        );
        studentService.printName();
    }
}

