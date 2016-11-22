package spring.jdbc;

import org.springframework.context.ApplicationContext;
import spring.bean.MyClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by shiqining on 11/21/16.
 */
public class SpringJdbc {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring/spring-h2db.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        try {
            userService.insert("shiqiwei", 14);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        Map<String, Object> map = userService.query("shiqiwei");
        System.out.println(map);
    }
}
