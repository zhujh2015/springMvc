/**
 * Created by Administrator on 2018/1/23.
 * 锁操作
 */
public class SynchronizedTest {

    /*锁定义在方法上*/
    public synchronized  void SynchronizedTest0(){}
    /*如果定义在静态方法上则调用此方法的线程会拥有该类的锁*/
    public static synchronized  void SynchronizedTest1(){}
    /*锁定义在方法内*/
    public void SynchronizedTest2() {
        synchronized (this) {
            System.out.println("===测试同步锁");
        }
    }
}
