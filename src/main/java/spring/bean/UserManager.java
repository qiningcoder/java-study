package spring.bean;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Date;

/**
 * Created by shiqining on 11/17/16.
 */
public class UserManager  implements EnvironmentAware {
    private Date dateValue;
    private Environment environment;

    @Override
    public String toString() {
        return "UserManager{" +
                "dateValue=" + dateValue +
                '}';
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
