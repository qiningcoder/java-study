package guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by shiqining on 10/19/16.
 */
public class GuavaSubscriber {

    private static int cnt = 0;
    @Subscribe
    public void listen(String name) {
        int local = cnt++;
        System.out.println(local + " hello " + name);
    }

}
