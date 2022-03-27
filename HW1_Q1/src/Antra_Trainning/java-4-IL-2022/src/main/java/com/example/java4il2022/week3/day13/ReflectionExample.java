package com.example.java4il2022.week3.day13;


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<Day13Student> stu_clazz = Day13Student.class;

        Field[] f = stu_clazz.getDeclaredFields();
        System.out.println(f[0].getDeclaredAnnotations()[0]);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {}

@Component
class Day13Student {
    private String name;

    @Inject
    private Day13Teacher teacher1;

    @Inject
    private Day13Teacher teacher2;


    public void print() {
        System.out.println(this.name);
    }

    @Override
    public String toString() {
        return "Day13Student{" +
                "name='" + name + '\'' +
                ", teacher1=" + teacher1 +
                ", teacher2=" + teacher2 +
                '}';
    }
}

/**
 *   IOC
 *      container(factory)
 */
@Component
class Day13Teacher {

    @Override
    public String toString() {
        return "Day13Teacher{}";
    }
}

class MyIOCContainer {
    private Map<Class<?>, Object> map = new HashMap<>();

    public void scan() {
        map.put(Day13Teacher.class, new Day13Teacher());
        map.put(Day13Student.class, new Day13Student());
    }

    public void inject() throws Exception {
        Set<Class<?>> classes =  map.keySet();
        for(Class clazz: classes) {
            Object obj = map.get(clazz);
            Field[] fields = clazz.getDeclaredFields();
            for(Field f: fields) {
                for(Annotation ano: f.getAnnotations()) {
                    if(ano.annotationType() == Inject.class) {
                        f.setAccessible(true);
                        f.set(obj, map.get(f.getType()));
                    }
                }
            }
        }
    }

    public void print() {
        System.out.println(map);
    }

    public static void main(String[] args) throws Exception{
        MyIOCContainer container = new MyIOCContainer();
        container.scan();
        container.inject();
        container.print();
    }
}

