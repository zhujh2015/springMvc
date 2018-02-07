package hello.other.Collection;

import java.util.List;

/**
 * Created by Administrator on 2018/2/7.
 */
public class ReadThread implements Runnable {

    private List<String> list;

    public ReadThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (String ino : list) {
            System.out.println("read:" + ino);
        }
        System.out.println("readEnd:");
    }
}
