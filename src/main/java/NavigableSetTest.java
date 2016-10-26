import com.google.common.collect.Lists;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by shiqining on 10/26/16.
 */
public class NavigableSetTest {
    public static void main(String[] args) {
        NavigableSet<String> navigableSet = new TreeSet<String>();
        navigableSet.add("1");
        navigableSet.add("2");
        navigableSet.add("3");
        System.out.println(navigableSet.first());
        System.out.println(navigableSet.last());
        System.out.println(navigableSet.ceiling("5"));
        System.out.println(Lists.newArrayList(navigableSet.descendingIterator()));
        System.out.println(navigableSet.floor("0"));
        System.out.println(navigableSet.headSet("3", true));
        System.out.println(navigableSet.higher(""));
        System.out.println(navigableSet.pollFirst());
        System.out.println(navigableSet);
    }
}
