package hello.other.DelayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/29.
 */
public class UserMain {
    /*psvm*/
    public static void main(String[] args) {
        DelayQueue<Userinfo> queue = new DelayQueue<Userinfo>();
        queue.add(new Userinfo("用户5", 10));
        queue.add(new Userinfo("用户4", 6));
        queue.add(new Userinfo("用户3", 12));
        queue.add(new Userinfo("用户2", 4));
        queue.add(new Userinfo("用户1", 3));
        try {
            /*sout*/
            System.out.println(queue.size());
            System.out.println(queue.take().getUserName() + "" + System.currentTimeMillis());
            System.out.println(queue.take().getUserName() + "" + System.currentTimeMillis());
            System.out.println(queue.take().getUserName() + "" + System.currentTimeMillis());
            System.out.println(queue.take().getUserName() + "" + System.currentTimeMillis());
            System.out.println(queue.take().getUserName() + "" + System.currentTimeMillis());

            System.out.println(queue.size());


            long delayNanoTime=10;
            TimeUnit unit = TimeUnit.SECONDS;
            System.out.println("当前对象:"+System.nanoTime() + unit.toNanos(delayNanoTime));

            System.out.println(System.nanoTime());/*毫微秒为单位 纳秒 时间段*/
            System.out.println(7 - System.nanoTime());
            System.out.println(unit.convert(7 - System.nanoTime(), TimeUnit.NANOSECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
