package hello.other.DelayQueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * Created by Administrator on 2018/1/24.
 */
public class DelayMain implements Runnable {
    private static DelayQueue<OrderDelayItem> queue = new DelayQueue<>();

    /*获取目前队列
    * 执行移除*/
    public void initDelayQueue(DelayQueue<OrderDelayItem> queue) {
        for (int i = 0; i < 5; i++) {
            String codeStr = "编号" + i;
            long time = new Date().getTime() + i * 10;
            OrderDelayItem orderDelayItem = new OrderDelayItem(codeStr, 100, time);
            queue.add(orderDelayItem);
        }
    }

    public void removeDelayQueue() {
        OrderDelayItem orderDelayItem = null;
        try {
            orderDelayItem = queue.take();
            System.out.print("移除编号：" + orderDelayItem.getOrderCode());
            //queue.remove(orderDelayItem);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("检查Start。。。。");
            removeDelayQueue();
            System.out.print("移除End。。。。");
        }
    }

    public static void main(String[] args) {
        DelayMain delayMain = new DelayMain();
        System.out.print("开始。。。" + queue.size());
        delayMain.initDelayQueue(queue);
        System.out.print("队列长度：" + queue.size());

        while (true) {
            //  System.out.print("执行线程一次。。。");
            try {
                Thread.sleep(1000);
                new Thread(delayMain).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
