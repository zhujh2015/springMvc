package hello.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ProduceLock implements Runnable
{
   private Lock lock;
    public ProduceLock(Lock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            try {
                lock.lock();
                Condition condition=lock.newCondition();
                System.out.print("A2");
                count--;
            } finally {
                lock.unlock();
                try {
                    Thread.sleep(91L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
