package ua.com.vertex.util.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sweet_home on 06.11.16.
 */
public class IncrementExperiment {

    static private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

//        ArrayBlockingQueue<Thread> threads = new ArrayBlockingQueue<>(10);

        Object monitor = new Object();

        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    if (!Thread.currentThread().isInterrupted())
                        count.incrementAndGet();
                }
                System.out.println(Thread.currentThread().isInterrupted());
            });
//            threads.add(thread);
            thread.start();
//            thread.join();
            thread.interrupt();
        }
//        for (Thread thread: threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(count);
    }

}
