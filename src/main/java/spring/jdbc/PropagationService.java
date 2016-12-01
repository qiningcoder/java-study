package spring.jdbc;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by shiqining on 12/1/16.
 */
public class PropagationService {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void insertTwo(String name1, int age1, String name2, int age2) {
        throwException1();
        userService.insert1(name1, age1);
        throwException2();
        userService.insert2(name2, age2);
        throwException3();
    }

    private void throwException1() {
        //throw new RuntimeException("throwException1");
    }

    private void throwException2() {
        throw new RuntimeException("throwException2");
    }

    private void throwException3() {
        //throw new RuntimeException("throwException3");
    }
}
