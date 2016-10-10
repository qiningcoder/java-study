package guava;

import com.google.common.base.*;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shiqining on 9/28/16.
 */
public class GuavaStudy {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        testStrings();
        System.out.println(stopwatch.toString());
        testStopwatch();
        System.out.println(stopwatch.toString());
        testPredicate();
        System.out.println(stopwatch.toString());
        testFunction();
    }

    public static void testStrings() {
        Assert.assertEquals("guava", Strings.nullToEmpty("guava"));
        Assert.assertEquals("", Strings.nullToEmpty(null));
        Assert.assertEquals("guavaxxxxx", Strings.padEnd("guava", 10, 'x'));
        Assert.assertEquals("xxxxxguava", Strings.padStart("guava", 10, 'x'));
        Assert.assertEquals("xxx", Strings.repeat("x", 3));
    }

    public static void testStopwatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(5);
        stopwatch.stop();
        Assert.assertEquals(5, stopwatch.elapsed(TimeUnit.SECONDS));
        TimeUnit.SECONDS.sleep(1);
        stopwatch.start();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertEquals(8, stopwatch.elapsed(TimeUnit.SECONDS));
    }

    public static void testPredicate() {
        List<String> stringList = Lists.newArrayList("first", "second", "third",
                "four", "five", "six");
        Assert.assertTrue(Lists.newArrayList(Iterables.filter(stringList,
                Predicates.<String>alwaysFalse())).isEmpty());

        Assert.assertEquals(stringList.size(), Lists.newArrayList(Iterables.
                filter(stringList, Predicates.<String>alwaysTrue())).size());

        Predicate<String> predicateFirst = new Predicate<String>() {
            public boolean apply(String s) {
                return "first".equals(s);
            }
        };

        Predicate<String> predicateSecond = new Predicate<String>() {
            public boolean apply(String s) {
                return "second".equals(s);
            }
        };

        Assert.assertEquals(1, Lists.newArrayList(Iterables.filter(stringList,
                predicateFirst)).size());
        Assert.assertEquals(5, Lists.newArrayList(Iterables.filter(stringList,
                Predicates.not(predicateFirst))).size());
        Assert.assertTrue(Lists.newArrayList(Iterables.filter(stringList,
                Predicates.and(predicateFirst, predicateSecond))).isEmpty());
        Assert.assertEquals(2, Lists.newArrayList(Iterables.filter(stringList,
                Predicates.or(predicateFirst, predicateSecond))).size());
    }

    public static void testFunction() {
        Function<Integer, String> f = new Function<Integer, String>() {
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        List<String> results = Lists.transform(integers,f);
        Assert.assertEquals(5, results.size());
    }
}
