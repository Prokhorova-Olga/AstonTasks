package ru.aston.hometask.homeWork4;

import java.util.concurrent.atomic.AtomicBoolean;

public class SynchronizedThreadsDemo {

    public static void main(String[] args) {

        Object lock = new Object();
        AtomicBoolean priority = new AtomicBoolean(true);

        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!priority.get()) {
                        try {
                            lock.wait();
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Поток был прерван во время ожидания " + e.getMessage());
                        }
                    }
                    System.out.print("1");
                    priority.set(false);
                    lock.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (priority.get()) {
                        try {
                            lock.wait();
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Поток был прерван во время ожидания " + e.getMessage());
                        }
                    }
                    System.out.print("2");
                    priority.set(true);
                    lock.notifyAll();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
