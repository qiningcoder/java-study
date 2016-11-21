package spring.bean;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * Created by shiqining on 11/21/16.
 */
public class SpringJdbc {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring/spring-h2db.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.update("insert into url_tbl(url) values (?)", new String[] {"www.google.com"}, new int[] {Types.VARCHAR});
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from url_tbl");
        Assert.assertEquals(result.size(), 3);
    }
}
