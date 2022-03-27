package com.example.java4il2022.week3;

/**
 *  OOD
 *      polymorphism / abstraction / encapsulation / inheritence
 *  SOLID principle
 *      Single responsibility
 *      Open - close
 *      Liskov substitution
 *      Interface Segregation
 *      Dependency inversion
 *          class A {
 *              B b
 *          }
 *   Design pattern
 *      Singleton
 *      Builder
 *      Factory
 *      Template
 *      Prototype
 *      Facade
 *
 *
 *      Bridge
 *      Strategy
 *      Adapter
 *      Observer
 *      Decoration = static proxy
 *      Dynamic Proxy
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton
 *      eg.  Properties
 *      Property p = new Property(file);
 *
 */
class SingletonEagerLoading {
    private static final SingletonEagerLoading obj = new SingletonEagerLoading();
    private SingletonEagerLoading() {}
    public static SingletonEagerLoading getInstance() {
        return obj;
    }
}
//double check solution
class SingletonLazyLoading {
    private volatile static SingletonLazyLoading obj;
    private SingletonLazyLoading() {}
    public static SingletonLazyLoading getInstance() {
        if(obj == null) {
            synchronized (SingletonLazyLoading.class) {
                if(obj == null) {
                    obj = new SingletonLazyLoading();
                }
            }
        }
        return obj;
    }
}
//enum


/**
 * Builder
 */

class Day11Student {
    private String name;
    private int age;
    private int id;
    //..
    //..
    //..
    //..

    public Day11Student() {
    }

    public Day11Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Day11Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Day11Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int getId() {
        return id;
    }

    public Day11Student setId(int id) {
        this.id = id;
        return this;
    }

    public static void main(String[] args) {
        Day11Student ss = new Day11Student().setName("aa").setAge(12).setId(1);
    }
}


/**
 * factory
 *      loose coupling ?
 *
 * A {
 *     public ..method() {
 *         B b = BFactory.getB();
 *     }
 * }
 */

class FactoryDesignPattern {
    public static Day11Student getStudent() {
        return new Day11Student();
    }
}


/**
 *  Template
 */
class Car {
    public void drive() {
        System.out.println("drive");
    }
    public void stop() {
        System.out.println("this is stop");
    }
}
class Benz extends Car {
    public void airCondition() {
        System.out.println("this is air condition");
    }
}

/**
 * prototype
 *      cloneable
 *          diff shallow copy vs deep copy
 */


/**
 * question1
 *      what is immutable
 * question2
 *      how to create immutable
 *
 */
final class MyImmutable {
    private final int v;
    private final List<Integer> list;

    public MyImmutable(int v, List<Integer> list) {
        this.v = v;
        this.list = list;
        //deep copy
    }

    public int getV() {
        return v;
    }

    public List<Integer> getList() {
        //return deep copy
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        MyImmutable obj = new MyImmutable(5, list);
        list.add(5);
        System.out.println(obj.getList()); // [] / [5]
    }
}

class Day11Student1 {
    Day11Teacher1 t1;
}
class Day11Teacher1 {

}

/**
 *
 *      ->               ->  class1
 *      ->      Facade   ->  class2
 *      ->               ->  class3
 */

/**
 *
 *  *      Bridge
 *  *      Strategy
 *  *      Adapter
 *  *      Observer
 *  *      Decoration = static proxy
 *  *      Dynamic Proxy
 *
 *  Reflection
 */