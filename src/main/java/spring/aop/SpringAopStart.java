package spring.aop;

import org.springframework.context.ApplicationContext;
import spring.bean.MyClassPathXmlApplicationContext;

/**
 * Created by shiqining on 11/23/16.
 */
public class SpringAopStart {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring/spring-aop.xml");
        TestInterface testBean = (TestInterface) applicationContext.getBean("testBean");
        testBean.test1();

    }
}
