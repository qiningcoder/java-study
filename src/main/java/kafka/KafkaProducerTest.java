package kafka;

public class KafkaProducerTest {
    static class A {
        public volatile long a = 0;
    }

    static class B extends A {
        public long l,l1,l2,l3,l4,l5,l6;
    }


    static class MyThread extends Thread {
        A a;
        public MyThread(A a) {
            this.a = a;
        }

        public void run() {
            for (int i =0; i< 5000000; i++) {
                a.a = i;
            }
        }
    }

    public static void test(A[] arr) throws InterruptedException {
        long start = System.currentTimeMillis();
        MyThread[] myThreads = new MyThread[arr.length];
        for (int i = 0; i<arr.length; i++) {
            myThreads[i] = new MyThread(arr[i]);
            myThreads[i].start();
        }

        for (MyThread myThread : myThreads) {
            myThread.join();
        }

        System.out.println(System.currentTimeMillis() - start);

    }

    public static void main(String[] args) throws InterruptedException {
        A[] arr = new A[10];
        for (int i = 0; i< 10; i++) {
            arr[i] = new B();
        }

        for (int i = 0; i< 50; i++) {
            test(arr);
        }
    }
}
