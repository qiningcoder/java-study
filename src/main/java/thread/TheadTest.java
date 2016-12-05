package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shiqining on 12/5/16.
 */
public class TheadTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (a) {
                        a.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    int v = atomicInteger.incrementAndGet();
                    System.out.println(v + "--" + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        b.notify();
                    }
                    try {
                        synchronized (a) {
                            a.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    int v = atomicInteger.incrementAndGet();
                    System.out.println(v + "--" + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a) {
                        a.notify();
                    }
                    try {
                        synchronized (b) {
                            b.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        aThread.start();
        bThread.start();
        aThread.join();
        bThread.join();
    }
}
