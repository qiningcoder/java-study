package spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Map;

/**
 * Created by shiqining on 11/22/16.
 */
@Transactional
public class UserService {
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NESTED)
    public void insert1(String name, int age) {
        jdbcTemplate.update("insert into user(name, age) values (?, ?)", new Object[] {name, age},
                new int[] {Types.VARCHAR, Types.INTEGER});
    }

    public void insert2(String name, int age) {
        jdbcTemplate.update("insert into user(name, age) values (?, ?)", new Object[] {name, age},
                new int[] {Types.VARCHAR, Types.INTEGER});
    }

    public Map<String, Object> query(String name) {
        try {
            return jdbcTemplate.queryForMap("select * from user where name = \'" + name + "\'");
        } catch (RuntimeException e) {
            return null;
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
