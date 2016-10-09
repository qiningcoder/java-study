package guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import org.junit.Assert;

import java.util.List;

/**
 * Created by shiqining on 10/9/16.
 */
public class OrderingTest {
    public static void main(String[] args) {
        List<String> strList = ImmutableList.of("a", "c", "e", "b");
        Ordering<String> naturalOrdering = Ordering.natural();
        System.out.println(naturalOrdering.sortedCopy(strList));
        List<Integer> intList = ImmutableList.of(1,5, 3, 8);
        List<Integer> sortedIntList = Ordering.natural().sortedCopy(intList);
        Assert.assertTrue(Ordering.natural().isOrdered(sortedIntList));
        Assert.assertTrue(Ordering.natural().isStrictlyOrdered(sortedIntList));
    }
}
