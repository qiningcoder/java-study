package spring.jdbc;

import org.springframework.context.ApplicationContext;
import spring.bean.MyClassPathXmlApplicationContext;

/**
 * Created by shiqining on 11/21/16.
 */
public class SpringJdbc {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring/spring-h2db.xml");
        PropagationService propagationService = (PropagationService) applicationContext.getBean("propagationService");
        try {
            propagationService.insertTwo("sqn", 24, "sqw", 13);
        } catch (Exception e) {
            System.out.println(e);
        }

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService.query("sqn"));
        System.out.println(userService.query("sqw"));
    }
}
