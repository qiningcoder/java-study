package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shiqining on 11/15/16.
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("VAR");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring/spring-beans.xml");
        MyEvent myEvent = new MyEvent("first", "hello");
        applicationContext.publishEvent(myEvent);
    }
}
