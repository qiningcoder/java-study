package guava;

import com.google.common.collect.*;

import java.util.Collection;

/**
 * Created by shiqining on 10/9/16.
 */
public class MultiMapTest {
    public static void main(String[] args) {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        for (int i = 0; i < 10; i ++) {
            multimap.put("city", "agent" + i);
        }
        Collection<String> c = multimap.get("city");
        System.out.println(c);//[agent0, agent1, agent2, agent3, agent4, agent5, agent6, agent7, agent8, agent9]

        Multiset<String> multiset = HashMultiset.create();
        for (int i = 0; i < 5; i ++) {
            multiset.add("f");
        }
        System.out.println(multiset.count("f"));
    }
}
