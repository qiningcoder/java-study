import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by shiqining on 10/26/16.
 */
public class Java8 {
    public static void main(String[] args) {
        Speak speak = msg -> System.out.println(msg);
        speak.say("dd");

        new Thread(() -> {
            System.out.println("hello");
        }).start();
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        list.forEach(n -> System.out.println(n + 5));

        Predicate<Integer> p = e -> e <= 3;
        p.and(p);
        list.removeIf(p);
        System.out.println(list);
        list.stream().map(x -> x * x).forEach((x) -> System.out.println(x));
        int sum = list.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }
}
