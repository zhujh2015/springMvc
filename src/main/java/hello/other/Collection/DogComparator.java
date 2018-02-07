package hello.other.Collection;

import java.util.Comparator;

/**
 * Created by Administrator on 2018/2/7.
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getDname().compareTo(o2.getDname());
    }
}
