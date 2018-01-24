package hello.common;

import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ConsumerLock implements Runnable
{
    private Lock lock;
    public ConsumerLock(Lock lock) {
        this.lock = lock;
    }

    @Override
    public  void run() {
        int count = 10;
        while (count > 0) {
            try {
                lock.lock();/*获取锁 如果锁被占用则一直等待*/
                count--;
                System.out.print("B2");
            } finally {
                lock.unlock();/*主动释放*/
                try {
                    Thread.sleep(91L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
