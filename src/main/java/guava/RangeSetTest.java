package guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * Created by shiqining on 10/24/16.
 */
public class RangeSetTest {
    public static void main(String[] args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 5));
        rangeSet.add(Range.closed(10, 15));
        System.out.println(rangeSet);
        rangeSet.add(Range.closed(5, 10));
        System.out.println(rangeSet);
    }
}
