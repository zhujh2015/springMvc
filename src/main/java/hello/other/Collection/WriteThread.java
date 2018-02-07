package hello.other.Collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2018/2/7.
 */
public class WriteThread implements Runnable {
    private CopyOnWriteArrayList<String> list;
    private String str0;

    public WriteThread(CopyOnWriteArrayList<String> list,String str) {
        this.list = list;
        this.str0=str;
    }

    @Override
    public void run() {
        list.add(str0);
    }
}
