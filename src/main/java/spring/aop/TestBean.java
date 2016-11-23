package spring.aop;

/**
 * Created by qiningshi on 16-11-22.
 */
public class TestBean implements TestInterface, TestInterface2 {
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("=test=");
    }

    public void test2() {

    }

    @Override
    public void test1() {

    }
}
