package hello.other.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/24.
 * 订单自动取消
 */
public class OrderDelayItem implements Delayed {
    private long expTime;/*过期时间*/
    private String orderCode;/*订单码*/

    public long getExpTime() {
        return expTime;
    }

    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public OrderDelayItem(String orderCode, long expTime, long createTime) {
        super();
        this.orderCode = orderCode;
        TimeUnit unit = TimeUnit.SECONDS;
        //this.expTime = TimeUnit.NANOSECONDS.convert(expTime, TimeUnit.NANOSECONDS) + createTime;
        this.expTime = System.nanoTime() + unit.toNanos(expTime);//+unit.toNanos(createTime);
       // System.out.println("实体："+createTime);
    }

    /*最前面订单出队时间:计算当前时间到执行时间之间还有多长时间。*/
    @Override
    public long getDelay(TimeUnit unit) {
       // System.out.println("delay:" + new Date().getTime());
        long delaylong = unit.convert(expTime - System.nanoTime()
               // - unit.toNanos(new Date().getTime())
               , TimeUnit.NANOSECONDS);
       // System.out.println("delaylong:" + delaylong);
        return delaylong;
    }

    /* 判断队列中元素的顺序谁前谁后。当前元素比队列元素后执行时，返回一个正数，
       比它先执行时返回一个负数，否则返回0.
     * 比较订单的顺序*/
    @Override
    public int compareTo(Delayed o) {
        return Long.valueOf(this.expTime).compareTo(Long.valueOf(((OrderDelayItem) o).expTime));
    }
}
