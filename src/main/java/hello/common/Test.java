package hello.common;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/1/10.
 */
public class Test
{
    public static final Object obj = new Object();

    private static final int nthreads=10;
    private static final Executor exec= Executors.newFixedThreadPool(nthreads);
    private static ExecutorService fixedThreadPool =Executors.newFixedThreadPool(10);
    private static ExecutorService cacheThreadPool =Executors.newCachedThreadPool();// Executors.newSingleThreadExecutor();
    private static ExecutorService singleThreadPool =Executors.newSingleThreadExecutor();
    private static ExecutorService scheduledThreadPool =Executors.newScheduledThreadPool(20);
    public static void main(String[] args) {
    /*不同的锁*/
   /*     System.out.println(new Date());
        new Thread(new ProduceSyn()).start();
        new Thread(new ConsumerSyn()).start();

        Lock lock = new ReentrantLock();
        ConsumerLock consumer = new ConsumerLock(lock);
        ProduceLock producer = new ProduceLock(lock);
        new Thread(consumer).start();
        new Thread(producer).start();
        System.out.println(new Date());*/
        /*串行执行任务 简单安全 大多数GUI框架都是通过单一线程来串行处理任务*/


        try {
            handleRequest("固定",fixedThreadPool);
            handleRequest("缓存",cacheThreadPool);
            handleRequest("单一",singleThreadPool);
            handleRequest("Timer",scheduledThreadPool);
            fixedThreadPool.shutdown();
            fixedThreadPool.shutdownNow();/**/

            DelayQueue de=new DelayQueue();/*队列*/
            de.take();
            /*运行 终止 关闭*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void  handleRequest(String typeStr,ExecutorService execService) {
        System.out.println("处理请求！！！开始：" + typeStr);
        for (int i = 0; i < 100; i++) {
            String logStr = typeStr + i;
            execService.execute(() -> {
                System.out.print(logStr);
            });
        }
        /*处理请求*/
        System.out.println("处理请求！！！结束：" + typeStr);
    }
    /*在一定范围内，增加线程可以提高系统的吞吐率，但如果超出这个范围，
    再创建更多范围只会降低程序的执行速度
    高负载情况下可能会内存溢出 所以需要控制创建线程的数量在并发情况下 可借鉴线程池
    （线程声明周期的开销非常高，资源消耗【内存 cpu】）
    */








        /*在并发量比较小的情况下，使用synchronized是个不错的选择，
        *在并发量比较高的情况下，其性能下降很严重，此时ReentrantLock是个不错的方案*/

         /*synchronized 和 Lock*/
        /*synchronized:当很多线程竞争时，会引起CPU 频繁的上下文切换导致效率很低  ,堵塞悲观锁 在jvm层面上
        * Lock:ReetrantLock实现锁接口, 非阻塞同步 乐观锁 在类上*/

        /*java 语言提供了一些底层机制 如：同步和条件等待
        * 高层组件
        * 在正常的负载下，服务器应用程序应该同时表现出良好的吞吐量和快速的相应性。
        * 大多数服务器应用程序都提供一种自然的任务边界选择方式，实现任务的独立性*/


}
