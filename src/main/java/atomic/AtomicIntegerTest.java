package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shiqining on 12/5/16.
 */
public class AtomicIntegerTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int cnt = 0;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n1 = 100;
        int n2 = 10000;
        int n3 = 1000000;
        for (int i = 0; i < n3; i++) {
            add(atomicInteger);
        }
        System.out.println("-----" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < n3; i++) {
            add();
        }
        System.out.println("-----" + (System.currentTimeMillis() - start));

    }

    private static void add(AtomicInteger atomicInteger) {
        atomicInteger.incrementAndGet();
    }

    private synchronized static void add() {
        cnt ++;
    }


}
