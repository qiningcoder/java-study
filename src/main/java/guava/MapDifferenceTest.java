package guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Assert;

import java.util.Map;

/**
 * Created by shiqining on 10/25/16.
 */
public class MapDifferenceTest {
    public static void main(String[] args) {
        // 比较具有两个相同key,相同value的Map
        MapDifference<String, Integer> differenceMap = Maps.difference(ImmutableMap.of("k1", 1),
                ImmutableMap.of("k1", 1));
        Assert.assertTrue(differenceMap.areEqual());

        differenceMap = Maps.difference(ImmutableMap.of("k1", 1, "k2", 2, "k3", 3, "k4", 4),
                ImmutableMap.of("k2", 2, "k3", 3, "k4", 44, "k5", 5));
        Assert.assertFalse(differenceMap.areEqual());
        Assert.assertTrue(Maps.difference(differenceMap.entriesInCommon(), ImmutableMap.of("k2", 2, "k3", 3)).areEqual());
        Assert.assertTrue(Maps.difference(differenceMap.entriesOnlyOnLeft(), ImmutableMap.of("k1", 1)).areEqual());
        Assert.assertTrue(Maps.difference(differenceMap.entriesOnlyOnRight(), ImmutableMap.of("k5", 5)).areEqual());
        Map<String, MapDifference.ValueDifference<Integer>> valueDifference = differenceMap.entriesDiffering();
        Assert.assertEquals(1, valueDifference.size());
        Assert.assertTrue(valueDifference.containsKey("k4"));
        Assert.assertTrue(4 == valueDifference.get("k4").leftValue());
        Assert.assertTrue(44 == valueDifference.get("k4").rightValue());

    }
}