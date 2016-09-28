package guava;

import com.google.common.base.Strings;
import org.junit.Assert;

/**
 * Created by shiqining on 9/28/16.
 */
public class GuavaStudy {
    public static void main(String[] args) {
        testStrings();
        testStopwatch();
    }

    public static void testStrings() {
        Assert.assertEquals("guava", Strings.nullToEmpty("guava"));
        Assert.assertEquals("", Strings.nullToEmpty(null));
        Assert.assertEquals("guavaxxxxx", Strings.padEnd("guava", 10, 'x'));
        Assert.assertEquals("xxxxxguava", Strings.padStart("guava", 10, 'x'));
        Assert.assertEquals("xxx", Strings.repeat("x", 3));
    }

    public static void testStopwatch() {
    }
}
