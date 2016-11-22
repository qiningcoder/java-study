package spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Map;

/**
 * Created by shiqining on 11/22/16.
 */
@Transactional
public class UserService {
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert(String name, int age) {
        jdbcTemplate.update("insert into user(name, age) values (?, ?)", new Object[] {name, age},
                new int[] {Types.VARCHAR, Types.INTEGER});

        jdbcTemplate.update("insert into user(name, age) values (?, ?)", new Object[] {name + "2", age},
                new int[] {Types.VARCHAR, Types.INTEGER});
//        throw new RuntimeException("ddd");
    }

    public Map<String, Object> query(String name) {
        return jdbcTemplate.queryForMap("select * from user where name = \'" + name + "\'");
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
