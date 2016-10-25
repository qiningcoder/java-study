package guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by shiqining on 10/19/16.
 */
public class EventBusTest {
    public static void main(String[] args) {
        Executor executor = Executors.newScheduledThreadPool(100);
        EventBus eventBus = new AsyncEventBus(executor);
        for (int i = 0; i < 10000;i++) {
            eventBus.register(new GuavaSubscriber());
        }
        eventBus.post("sqn");
    }
}
