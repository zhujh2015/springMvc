package hello.other.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/26.
 */
public class Userinfo implements Delayed
{

    private long delayNanoTime;/*延迟纳秒*/
    private String userName;

    public long getDelayNanoTime() {
        return delayNanoTime;
    }

    public void setDelayNanoTime(long delayNanoTime) {
        this.delayNanoTime = delayNanoTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Userinfo(String userName,long delayNanoTime) {
        super();
        this.userName = userName;
        TimeUnit unit = TimeUnit.SECONDS;
        this.delayNanoTime = System.nanoTime() + unit.toNanos(delayNanoTime);
    }
    @Override
    public long getDelay(TimeUnit unit) {
     return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS) < 0) {
            return -1;
        }
        if (this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS) > 0) {
            return 1;
        }
        return 0;
    }


















}
