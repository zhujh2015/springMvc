package hello.other.DelayQueue;

import hello.other.Collection.Dog;
import hello.other.Collection.DogComparator;
import hello.other.Collection.ReadThread;
import hello.other.Collection.WriteThread;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/1/24.
 */
public class DelayMain implements Runnable {
    private static DelayQueue<OrderDelayItem> queue = new DelayQueue<OrderDelayItem>();

    //
    private static volatile int rcount = 0;
    private static AtomicInteger rcounta = new AtomicInteger(0);



    /*获取目前队列
    * 执行移除*/
    public void initDelayQueue(DelayQueue<OrderDelayItem> queue) {
        for (int i = 0; i < 5; i++) {
            String codeStr = "编号" + i;
            long time = new Date().getTime();
            time += i * 10;
            long delaytime = 2 + i * 10;/*超时时间*/
            OrderDelayItem orderDelayItem = new OrderDelayItem(codeStr, delaytime, time);
            queue.put(orderDelayItem);
        }
    }

    public void removeDelayQueue() {
        OrderDelayItem orderDelayItem = null;
        while (queue.size() > 0) {
            try {
                orderDelayItem = queue.take();/*获取队首元素 如果为空则等待*/
                System.out.println("移除编号：" + orderDelayItem.getOrderCode());
                System.out.println("队列：" + queue.size() + "时间:" + new Date());
                //queue.remove(orderDelayItem);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
           /* System.out.print("检查Start。。。。");*/
            removeDelayQueue();
          /*  System.out.print("移除End。。。。");*/
        }
    }

    public void hisTest() {/*  System.out.println("开始。。。" + queue.size());
        delayMain.initDelayQueue(queue);
        System.out.println("队列长度：" + queue.size());
        while (true) {
            //  System.out.print("执行线程一次。。。");
            try {
                Thread.sleep(1000);
                new Thread(delayMain).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        // delayMain.getInitSet();
        // System.out.println("ffff");
        //  delayMain.getInitSet();
        // System.out.println("ffff");
        //  delayMain.getInitMap();
        //  delayMain.ConcurrentHashMapTest();

    }

    public static void main(String[] args) {
        DelayMain delayMain = new DelayMain();
        // delayMain.CopyOnWriteArrayListTest();



        delayMain.CountTest();
    }

    public void getInitSet() {
        Set<String> set = new TreeSet<>();
        set.add("123");
        set.add("3231");
        set.add("123");
        set.add("3231");
        System.out.println(set.size());
        for (String str : set) {
            System.out.println(str);
        }
    }

    public void getInitList() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("1231");
        list.add("123");
        list.add("1231");
        list.add(null);
        list.add(null);
        System.out.println(list.size());

        ArrayList arrayList = new ArrayList();


        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if ("123".equals(obj)) {
                it.remove();
            }
        }
        System.out.println(list.size());

        for (String str : list) {
            System.out.println(str);
        }
        /*Iterator itr=list.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }*/
    }

    public void getInitMap() {
        // new ConcurrentHashMap<>(); //
        Map<String, String> map = new WeakHashMap<>();
        //new LinkedHashMap<>(); //
        // new ConcurrentHashMap<>(); //new HashMap<>();
        // new ConcurrentHashMap<>();
        //new WeakHashMap<>()
        map.put("A1", "aa");
        map.put("B1", "bb");
        map.put("C1", "cc");
        map.put("D1", "dd");
        map.put(null, null);
        //map.put(null,"ee");
           /*transient volatile 稍弱的同步机制
           * volatile变量是一种比sychronized关键字更轻量级的同步机制。
           * transient:我们不想用serialization机制来保存它。为了在一个特定对象的一个域上关闭serialization，可以在这个域前加上关键字transient*/
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map0 = (Map.Entry) it.next();
            System.out.println(map0.getKey() + " = " + map0.getValue());
        }
        System.out.println(map.size());
        System.out.println(map.size());

    }

    /*concurrentHashMap 测试*/
    public void ConcurrentHashMapTest() {
        Map<String, String> map = new ConcurrentHashMap<>();
        Thread threadA = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        map.put("a", "A");
                        // System.out.println(rcount);
                    /*操作日志 测试*/
                    }
                });
        Thread threadB = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        map.put("b", "B");
                        // System.out.println(rcount);
                    /*操作日志 测试*/
                    }
                });
        threadA.start();
        threadB.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("计数量：" + map.size());
    }

    /*计数-- 多线程 测试并不安全*/
    public void CountTest() {

        for (int i = 0; i < 1000; i++) {
            Thread threadA = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            rcounta.getAndAdd(1);
                           // rcounta.set(rcounta.incrementAndGet());
                            rcount += 1;
                        }
                    });
            threadA.start();
        }
        try {
            Thread.sleep(10);
            System.out.println("计数量A：" + rcounta.get());
            System.out.println("计数量：" + rcount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ArraySortTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("d");

        String[] list0 = list.toArray(new String[list.size()]);
        Arrays.sort(list0);
        for (String str : list0) {
            System.out.println(str);
        }
        System.out.println("排序前");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public void ModelArraySortTest() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(1, "D"));
        list.add(new Dog(1, "E"));
        list.add(new Dog(1, "A"));
        list.add(new Dog(1, "B"));
        for (Dog dog : list) {
            System.out.println(dog.getDname());
        }
        list.sort(new DogComparator());

        System.out.println("排序后");
        for (Dog dog : list) {
            System.out.println(dog.getDname());
        }

    }

    public void CopyOnWriteArrayListTest() {
        CopyOnWriteArrayList<String> copyList = new CopyOnWriteArrayList<>();
        copyList.add("a");
        copyList.add("b");
        copyList.add("c");
        copyList.add("d");
        copyList.get(0);
        /*读写*/
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList, "e"));
        executorService.execute(new WriteThread(copyList, "f"));
        executorService.execute(new WriteThread(copyList, "g"));

        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList, "h"));

        executorService.execute(new ReadThread(copyList));

        executorService.execute(new WriteThread(copyList, "i"));

        executorService.execute(new ReadThread(copyList));
    }

    public void ReenTrantLockTest()
    {
        Lock lock = new ReentrantLock();/*true  false 公平所*/
        Condition condition=lock.newCondition();
        Thread.interrupted();

        try {

            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
