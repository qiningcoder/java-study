package spring.bean;

import org.springframework.context.Lifecycle;

/**
 * Created by qiningshi on 16-11-20.
 */
public class MyLifecycleBean implements Lifecycle {
    private String name;

    public MyLifecycleBean(String name) {
        System.out.println("constructor");
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
