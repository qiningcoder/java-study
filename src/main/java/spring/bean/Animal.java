package spring.bean;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by shiqining on 10/31/16.
 */
public abstract class Animal implements BeanNameAware {
    protected String name;
    protected int speed;

    public String desc() {
        return "I'm a " + name + ", my speed is " + speed + "km/h";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setBeanName(String name) {
        System.out.println("====name=" + name);
    }
}
