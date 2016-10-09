package guava;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.junit.Assert;

/**
 * Created by shiqining on 10/9/16.
 */
public class IterablesTest {
    public static void main(String[] args) {
        Predicate<Integer> gt7 = new Predicate<Integer>() {
            public boolean apply(Integer input) {
                return input > 7;
            }
        };
        Assert.assertEquals(1, ImmutableList.copyOf(Iterables.filter(ImmutableList.of(1, 5, 7, 8), gt7)).size());
        Assert.assertTrue(Iterables.all(ImmutableList.of(1, 2, 3),
                new Predicate<Integer>() {
                    public boolean apply(Integer input) {
                        return input > 0;
                    }
                }));
        Assert.assertTrue(Iterables.any(ImmutableList.of(1, 2, 3),
                new Predicate<Integer>() {
                    public boolean apply(Integer input) {
                        return input > 2;
                    }
                }));

    }
}
