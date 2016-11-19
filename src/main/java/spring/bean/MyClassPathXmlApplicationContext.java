package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

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
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        System.out.println(userManager);
        Environment environment = userManager.getEnvironment();
    }
}
