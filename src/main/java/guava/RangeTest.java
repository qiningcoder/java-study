package guava;

import com.google.common.collect.Range;

/**
 * Created by shiqining on 10/25/16.
 */
public class RangeTest {
    public static void main(String[] args) {
        Range<Integer> range = Range.open(1, 5);
        range.contains(4);
    }
}
