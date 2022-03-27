package com.example.java4il2022.week3;

/**
 *
 *
 * day1: basic java / oop concept / static /  finalize
 * day2: collection
 * day3: jvm / heap / stack / gc
 * day4: multi-threading?
 * day5: java 8
 *
 *
 *  Object o1 = new Object();
 *  o1.method();
 *  questions1 :
 *      scope of synchronized
 *      method() {
 *            synchronized(refernce) {
 *
 *            }
 *      }
 *
 *      static synchronized method() {
 *
 *      }
 *
 *  question2 :
 *      what is finalize ?
 *      finalize() {
 *
 *      }
 *      Strong / Soft / Weak / PhantomReference + ReferenceQueue
 *
 *  question3 :
 *      what is out of memory error ?
 *          [eden area][s0][s1] young generation
 *          [                 ] old generation
 *          1. when heap is full
 *      how to solve this error / what will you do if you get out of memory error ?
 *          1. increase heap size
 *          2. change reference type
 *          3. restart - jvm
 *          4. solve -> memory leak
 *             heap dump -> analyze / Jprofiler / memory analyzer
 *          ...
 *  questions4 :
 *      what is stack
 *      what is stackoverflow error ?
 *              ..
 *              method frame
 *              method frame
 *              method frame
 *              stack
 *  question5 :
 *      pass by value
 *
 *      public void method1() {
 *          List<Integer> list1 = new ArrayList<>();
 *          list1.add(10);
 *          method2(list1);
 *          System.out.println(list1);
 *      }
 *      public void method2(List<Integer> list2) {
 *          list2 = new ArrayList<>();
 *      }
 *      list1 => obj1
 *      list2 => new ArrayList<>()
 *  question6 :
 *      why isn't volatile thread safe?
 *      CPU                 CPU
 *       i                   i
 *
 *
 *          main    memory
 *
 *  question7 :
 *      ConcurrentHashMap vs Hashtable vs HashMap
 *
 *  question8 :
 *      what is blocking queue
 *          producer ->  blocking queue -> consumer
 *          1. if queue is full -> blocks producer
 *          2. if queue is empty -> blocks consumer
 *  question9 :
 *      ThreadPool in Java
 *      1. CachedThreadPool  -> ThreadPoolExecutor
 *      2. FixedThreadPool  -> ThreadPoolExecutor
 *      3. ScheduledThreadPool -> DelayQueue
 *      4. ForkJoinPool
 *          [][][][][]  -> w1  [][][]
 *                      -> w2  [][][]
 *          stealing
 *
 *      Executors.
 *  question10 :
 *      ReentrantLock vs Synchronized
 *      1. fair lock vs unfair lock
 *         unfair lock ?
 *         fair lock
 *
 *        monitor    T1 - T2 - T3
 *                   T5
 *      2. try lock
 *      3. condition => multi waiting list
 *      4. lock multiple times
 *
 *  question11 :
 *      plain select statement / no-lock statement
 *          select..
 *      optimistic vs pessimistic lock
 *      1. pessimistic lock
 *      2. optimistic lock
 *
 *          user1                       user2
 *                    id  salary
 *                    1    10k
 *
 *          user1                       user2
 *          1 10k                       1  10k
 *          update 10k - 20k            update 10k - 30k
 *               \                      /
 *                    id  salary
 *                    1    10k / 20k / 30k / 50k


 *          user1                       user2
 *          1 10k 1                      1  10k  1
 *          update 10k - 20k              update 10k - 30k
 *                version 1 = 2                  version 1 = 2
 *          where version = 1             where version = 1
 *                    id  salary version
 *                    1    10k    1
 *
 *           if user1 updates first
 *                id    salary      version
 *                1     20k            2
 *           if user2 updates first
 *                id   salary   version
 *                1     30k       2
 *
 *      read lock vs write lock
 *      1.read lock blocks write lock
 *         select .. share
 *      2. write lock blocks read + write lock
 *         update / insert / delete
 *         select  ..   for update
 *
 *
 *  Tuesday
 *  20min
 *  * db
 *  * vertical scaling vs horizontal scaling
 *  * non-cluster index + bitmap index
 *  * oracle database architecture
 *  10 - 20min
 *  coding
 *  70min
 *  Design patterns
 *
 *
 *  Wednesday
 *  Design patterns
 *  Reflection
 *
 *  Thursday
 *  Java 8
 *  JDBC / connection
 *
 *  Friday
 *  ORM
 */