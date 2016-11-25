package spring.aop;


/**
 * Created by shiqining on 11/24/16.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("----add-----");
    }

    @Override
    public void delete() {
        System.out.println("-----delete----");
    }
}
