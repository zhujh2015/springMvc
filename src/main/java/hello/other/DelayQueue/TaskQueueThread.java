package hello.other.DelayQueue;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/24.
 */
public class TaskQueueThread
{

    /**
     * <p>
     * [任务调度系统]
     * <br>
     * [队列中要执行的任务]
     * </p>
     *
     * @author brucekellan
     * @create 2018-01-10
     */
    private final Logger logger = LoggerFactory.getLogger(TaskQueueThread.class);
        private static class LazyHolder {
            private static TaskQueueThread taskQueueDaemonThread = new TaskQueueThread();
        }

        public static TaskQueueThread getInstance() {
            return LazyHolder.taskQueueDaemonThread;
        }

        Executor executor = Executors.newFixedThreadPool(20);

        /**
         * 守护线程
         */
        private Thread daemonThread;

        /**
         * 初始化守护线程
         */
        public void init() {
            daemonThread = new Thread(() -> execute());
//        daemonThread.setDaemon(true);
            daemonThread.setName("Task Queue Thread");
            daemonThread.start();
        }


        private void execute() {
            System.out.println("start:" + System.currentTimeMillis());
            while (true) {
                try {
                    //从延迟队列中取值,如果没有对象过期则队列一直等待，
                    Task t1 = t.take();
                    if (t1 != null) {
                        //修改问题的状态
                        Runnable task = t1.getTask();
                        if (task == null) {
                            continue;
                        }
                        executor.execute(task);
                        logger.info("[at task:" + task + "]   [Time:" + System.currentTimeMillis() + "]");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /**
         * 创建一个最初为空的新 DelayQueue
         */
        private DelayQueue<Task> t = new DelayQueue<>();

        /**
         * 添加任务，
         * time 延迟时间
         * task 任务
         * 用户为问题设置延迟时间
         */
        public void put(long time, Runnable task) {
            //转换成ns
            long nanoTime = TimeUnit.NANOSECONDS.convert(time, TimeUnit.MILLISECONDS);
            //创建一个任务
            Task k = new Task(nanoTime, task);
            //将任务放在延迟的队列中
            t.put(k);
        }

        /**
         * 结束任务
         *
         * @param task
         */
        public boolean endTask(Task<Runnable> task) {
            return t.remove(task);
        }

        public static void main(String[] args) throws InterruptedException {
            TaskQueueThread taskQueueDaemonThread = TaskQueueThread.getInstance();
            for (int i = 0; i < 10; i++) {
                taskQueueDaemonThread.put(1000 * (i + 1), new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("now: " + System.currentTimeMillis());
                    }
                });
            }
            taskQueueDaemonThread.init();
        }
}
