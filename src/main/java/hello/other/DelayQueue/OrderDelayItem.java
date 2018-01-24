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

    public OrderDelayItem(String orderCode,long expTime,long createTime) {
        super();
        this.orderCode = orderCode;
        this.expTime = TimeUnit.MILLISECONDS.convert(expTime, TimeUnit.DAYS) + createTime;
    }
    /*最前面订单出队时间*/
    @Override
    public long getDelay(TimeUnit unit) {
        return expTime - System.currentTimeMillis();
    }
    /*延迟队列内部比较排序 当前的延迟事件--比较对象延迟时间
    * 比较订单的顺序*/
    @Override
    public int compareTo(Delayed o) {
        return Long.valueOf(this.expTime).compareTo(Long.valueOf(((OrderDelayItem) o).expTime));
    }

}
