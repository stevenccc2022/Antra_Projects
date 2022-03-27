package com.example.java4il2022.week3;

/**
 *  *      Bridge
 *  *      Strategy
 *  *      Adapter
 *  *      Observer
 *  *      Decoration = static proxy
 *  *      Dynamic Proxy
 *
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/**
 * Bridge
 */
class Day12A {
    void print() {

    }
}
class Day12Bridge {
    private Day12A day12A;

    public Day12Bridge(Day12A day12A) {
        this.day12A = day12A;
    }

    public void print() {
        day12A.print();
    }
}

/**
 * strategy
 */

class Day12Strategy {

    public void print(Day12A day12A) {
        day12A.print();
    }
}

/**
 * adapter
 */
interface Day12StudentService {
    void printName();
}
class Day12StudentServiceImpl implements Day12StudentService {
    public void printName() {

    }
}
interface Day12StudentServiceV2 {
    void printStudent();
}
class Day12Adapter implements Day12StudentServiceV2{

    private Day12StudentServiceImpl day12StudentService;

    public Day12Adapter(Day12StudentServiceImpl day12StudentService) {
        this.day12StudentService = day12StudentService;
    }

    @Override
    public void printStudent() {
        day12StudentService.printName();
    }
}
/**
 *  Observer
 */
class Day12Subscriber {
    public void receive(String msg) {

    }
}
class Day12Publisher {
    private List<Day12Subscriber> subscribers = new ArrayList<>();
    public void subscribe(Day12Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void send(String msg) {
        for(Day12Subscriber subscriber: subscribers) {
            subscriber.receive(msg);
        }
    }
}

/**
 *  decorator / static proxy
 */
interface ThirdPartyInterface {
    void print();
}
class ThirdPartyImpl implements ThirdPartyInterface{
    public void print() {
        System.out.println("this is my third party impl1");
    }
}
class ThirdPartyImplSub extends ThirdPartyImpl {
    public void print() {
        System.out.println("before");
        super.print();
        System.out.println("after");
    }
}
class ThirdPartyImplProxy implements ThirdPartyInterface{
    private final ThirdPartyImpl ss;

    public ThirdPartyImplProxy(ThirdPartyImpl ss) {
        this.ss = ss;
    }

    public void print() {
        System.out.println("before");
        ss.print();
        System.out.println("after");
    }
}

/**
 *  dynamic proxy
 */

class Day12DynamicProxy {
    public static void main(String[] args) {
        ThirdPartyInterface proxy = (ThirdPartyInterface) Proxy.newProxyInstance(
                Day12DynamicProxy.class.getClassLoader(),
                new Class[]{ThirdPartyInterface.class},
                new Day12InvocationHandler(new ThirdPartyImpl())
        );
        proxy.print();
    }
}
class Day12InvocationHandler implements InvocationHandler {
    private final ThirdPartyInterface realInstance;

    public Day12InvocationHandler(ThirdPartyInterface realInstance) {
        this.realInstance = realInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(realInstance, args);
        System.out.println("after");
        return res;
    }
}
/**
 *   question1:
 *      class A {
 *          void funA() {}
 *          void print() {
 *              //print abc
 *          }
 *      }
 *      class B {
 *          void funB() {}
 *          void print() {
 *              //print abc
 *          }
 *      }
 *
 *      1. strategy
 *      2. template / inheritance
 *                  C
 *                 / \
 *               A    B
 *      3. bridge pattern
 *      4. static method
 */

/**
 *  Composition
 */
class TreeNode {
    private TreeNode left;
    private TreeNode right;
}
class Node {

}

/**
 *  Has-A type
 *  IS -A type  -> inheritance
 */

/**
 *  Java 8
 *      1. stream api
 *      2. lambda expression
 *      3. functional interface
 *      4. optional
 *      5. completable future
 *      6  default method from interface
 *
 *  why do we use stream ?
 *      functional programming
 *      parallel stream
 *  is stream api faster than for loop ?
 *      stream api
 *
 *  Stream<Integer> s = list.stream().map(x -> x * 2);
 *  list.add(5);
 *  List<Integer> res = s.collect(Collectors.toList())
 *
 *  itr = list.iterator();
 *  list.add(5);
 *  itr.next();
 */

class Day12IteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); //modCount = 0
//        Iterator<Integer> itr = list.iterator(); //iter(expectedModCount = 0) , modCount = 0
//        list.add(5); //modCount = 1
//        itr.next();

//        Supplier<Iterator<Integer>> iteratorSupplier1 = () -> list.iterator();
//        Supplier<Iterator<Integer>> iteratorSupplier2 = new Supplier<Iterator<Integer>>() {
//            @Override
//            public Iterator<Integer> get() {
//                return list.iterator();
//            }
//        };
//        list.add(5);
//        Iterator<Integer> itr = iteratorSupplier1.get();
//        System.out.println(itr.next());

        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<List<Integer>> ans = list.stream().collect(
                () -> Arrays.asList(new ArrayList<>(), new ArrayList<>()),
                (col, val) -> col.get((val % 2) ^ 1).add(val),
                (l1, l2) -> l1.addAll(l2)
        );
        System.out.println(ans);
    }
}

/**
 *  1. rewrite collect() function
 *  question:
 *      input [1, 2, 3, 4, 5, 6, 7, 8, 9]
 *      output [[1, 3, 5, 7, 9], [2, 4, 6, 8]]
 *      List<List<Integer>> ans = ..
 *  2. Completable Future vs Future
 *      a. CF.join() , Future.get()
 *      b. CF chain operation
 */

/**
 *  Reflection
 *  Customized Annotations IOC / AOP
 *  JDBC
 */
