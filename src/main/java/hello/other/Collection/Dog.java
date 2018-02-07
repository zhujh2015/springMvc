package hello.other.Collection;

/**
 * Created by Administrator on 2018/2/7.
 */
public class Dog {
    private int size;
    private String dname;

    public Dog(int size,String dname) {
        this.size = size;
        this.dname = dname;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
