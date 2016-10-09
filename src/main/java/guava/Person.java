package guava;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import org.junit.Assert;

import java.util.List;

/**
 * Created by shiqining on 10/9/16.
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private String face;

    public Person(String firstName, String lastName, int age, int height, String face) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.face = face;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", face='" + face + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person girl1 = new Person("shi", "qining", 24, 175, "nice");
        Person girl2 = new Person("shi", "qining", 24, 175, "ugly");
        Assert.assertTrue(girl1.compareTo(girl2) < 0);
        List<Person> pList = ImmutableList.of(
                new Person("shi", "qining", 24, 175, "Qnice"),
                new Person("shi", "qining", 28, 175, "Gnice"),
                new Person("shi", "qining", 27, 175, "Cnice"),
                new Person("shi", "qining", 25, 175, "Znice")
        );
        Function<Person, String> fun = new Function<Person, String>() {
            public String apply(Person input) {
                return input.face;
            }
        };
        System.out.println(Ordering.natural().greatestOf(pList, 2));
        System.out.println(Ordering.natural().onResultOf(fun).sortedCopy(pList));
        Assert.assertTrue(Ordering.natural().isStrictlyOrdered(ImmutableList.<Comparable>of(1, 2, 3)));
    }

    public int compareTo(Person that) {
        return ComparisonChain.start()
                .compare(firstName, that.firstName)
                .compare(lastName, that.lastName)
                .compare(age, that.age)
                .compare(height, that.height)
                .compare(face, that.face)
                .result();
    }
}
