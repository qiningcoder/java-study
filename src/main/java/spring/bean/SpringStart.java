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
        System.out.println("==========start=======");
        Animal dog = (Animal) xmlBeanFactory.getBean("dog");
        System.out.println(dog.desc());
        String[] beannames = xmlBeanFactory.getBeanDefinitionNames();
        Arrays.stream(beannames).forEach(name -> System.out.println(name));
        xmlBeanFactory.registerAlias("dog", "myDog");
        xmlBeanFactory.registerAlias("dog", "myDog2");
        Arrays.stream(xmlBeanFactory.getAliases("dog")).forEach(alias -> System.out.println(alias));
        Animal myDog = (Animal) xmlBeanFactory.getBean("myDog");
        System.out.println(myDog.desc());

        Person person = (Person) xmlBeanFactory.getBean("person");
        System.out.println(person.getPet().desc());
    }
}
