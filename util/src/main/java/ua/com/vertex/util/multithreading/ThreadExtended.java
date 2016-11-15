package ua.com.vertex.util.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadExtended extends Thread {


    public ThreadExtended(String name) {
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("in Run " + getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 100, TimeUnit.SECONDS, runnables);

        executor.execute(new ThreadExtended("first"));
        executor.execute(new ThreadExtended("second"));
    }
}
