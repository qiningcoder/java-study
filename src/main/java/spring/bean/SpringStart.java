package spring.bean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

/**
 * Created by shiqining on 10/31/16.
 */
public class SpringStart {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring/spring-beans.xml"));
        MyPostBeanProcessor myPostBeanProcessor = new MyPostBeanProcessor();
        xmlBeanFactory.addBeanPostProcessor(myPostBeanProcessor);
        Dog dog = (Dog) xmlBeanFactory.getBean("dog");
    }
}
