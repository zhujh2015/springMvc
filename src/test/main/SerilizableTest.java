import org.junit.Test;

import java.io.*;

/**
 * Created by Administrator on 2018/1/23.
 */
public class SerilizableTest {
    /*序列化测试*/
    @Test
    public void test0() {

        File file = new File("person.txt");
        //序列化持久化对象
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            Person person =Person.getInstance("Peter", "271");
            out.writeObject(person);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //反序列化，并得到对象
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Object newPerson = in.readObject(); // 没有强制转换到Person类型
            in.close();
            System.out.println(newPerson);
            Person person = (Person) newPerson;
            System.out.println(person.getpName());
            System.out.println(person.getpSex());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
