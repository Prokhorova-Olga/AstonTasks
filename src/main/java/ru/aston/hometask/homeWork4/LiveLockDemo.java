package ru.aston.hometask.homeWork4;

import java.util.concurrent.atomic.AtomicBoolean;

public class LiveLockDemo {

    public static void main(String[] args) {

        AtomicBoolean priority = new AtomicBoolean(true);

        Thread thread1 = new Thread(() -> {
            while (true) {
                if (priority.get()) {
                    System.out.println("Поток 1 пропускает поток 2");
                    priority.set(false);
                    System.out.println("Флаг изменен на false");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Поток 1 был прерван во время ожидания " + e.getMessage());
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                if (!priority.get()) {
                    System.out.println("Поток 2 пропускает поток 1");
                    priority.set(true);
                    System.out.println("Флаг изменен на true");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Поток 2 был прерван во время ожидания " + e.getMessage());
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
