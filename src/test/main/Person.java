import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/23.
 */
public class Person implements Serializable
{
    static Person person;
    private String pName;
    private String pSex;

     Person(String pName,String pSex) {
         this.pName = pName;
         this.pSex = pSex;
     }
    public static Person getInstance(String pName,String pSex) {
        if (person == null) {
            person = new Person(pName, pSex);
        }
        return person;
    }
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex;
    }
}
