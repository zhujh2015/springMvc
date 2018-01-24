package hello.common;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ConsumerSyn implements Runnable
{
    @Override
    public synchronized void run() {
        int count = 10;
        while (count > 0) {
            synchronized (Test.obj) {
                System.out.print("B1");
                count--;
                Test.obj.notify();/*主动释放*/

                try {
                    Test.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
