/**
 * Created by shiqining on 11/21/16.
 */
public class FinallyTest {
    public static void main(String[] args) {
        int a = getRandom();
        System.out.println(a);
    }

    private static int getRandom() {
        try {
            int a = 1;
            a += 1;
            return a;
        } finally {
            System.out.println("ddd");
        }
    }
}
