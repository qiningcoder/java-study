package spring.bean;

import org.springframework.context.ApplicationListener;

/**
 * Created by shiqining on 11/19/16.
 */
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getMsg());
    }
}
