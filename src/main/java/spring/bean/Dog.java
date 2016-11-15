package spring.bean;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by shiqining on 10/31/16.
 */
public class Dog extends Animal implements InitializingBean {
    public Dog() {
        System.out.println("call dog constructor");
    }

    public void initMethod() {
        System.out.println("initMethod");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
