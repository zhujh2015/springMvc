package hello.common;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ProduceSyn implements Runnable
{

    @Override
    public void run() {
        int count=10;
        while (count>0)
        {
            synchronized (Test.obj) {
                System.out.print("A1");
                count--;
                Test.obj.notify();
                try {
                    Test.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
