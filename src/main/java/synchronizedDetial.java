/**
 * Created by Administrator on 2018/1/23.
 */
public class synchronizedDetial
{
/* 程序-》进程-》线程
*线程是程序执行流的最小单位
* 而进程是系统进行资源分配和调度的一个独立单位。
* 以下我们所有讨论的都是建立在线程基础之上*/
    /*新建线程 Thread
    * 就绪状态：start()
    * 运行状态：run()
    * 阻塞状态：sleep()
    * 死亡状态：stop()*/

    /*wait() 与notify()/notifyAll() Object 的方法并非线程方法
    * wait()会释放对象锁 和释放cpu，而sleep()会暂时释放cpu,并不释放对象锁！
    * notify() 对对象锁的唤醒,会唤醒因调用对象的wait()而等待的线程，其中
    * wait()和notify()必须在synchronized 代码块中调用
    * notifyAll() 唤醒所有等待的线程*/



}
