package guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.junit.Assert;

/**
 * Created by shiqining on 10/24/16.
 */
public class RangeMapTest {
    public static void main(String[] args) {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 5), "lvl1");
        rangeMap.put(Range.closed(6, 10), "lvl2");
        rangeMap.put(Range.closed(11, 15), "lvl3");
        System.out.println(rangeMap);
        Assert.assertEquals("lvl1", rangeMap.get(1));
        Assert.assertEquals("lvl1", rangeMap.get(3));
        Assert.assertEquals("lvl1", rangeMap.get(5));
    }
}
