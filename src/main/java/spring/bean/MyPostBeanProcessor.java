package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by qiningshi on 16-11-14.
 */
public class MyPostBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("---postProcessBeforeInitialization----start");
        if (bean instanceof Dog) {
            Dog dog = (Dog) bean;
            System.out.println("dog name is " + dog.getName());
            System.out.println("dog speed is " + dog.getSpeed());
        }
        System.out.println("---postProcessBeforeInitialization----end");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("---postProcessAfterInitialization----start");
        if (bean instanceof Dog) {
            Dog dog = (Dog) bean;
            System.out.println("dog name is " + dog.getName());
            System.out.println("dog speed is " + dog.getSpeed());
        }
        System.out.println("---postProcessAfterInitialization----end");
        return bean;
    }
}
