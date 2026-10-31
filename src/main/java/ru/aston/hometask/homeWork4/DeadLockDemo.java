package ru.aston.hometask.homeWork4;

public class DeadLockDemo {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1 захватил lock1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Поток 1 был прерван во время ожидания: " + e.getMessage());
                }
                System.out.println("Поток 1 ждет lock2");
                synchronized (lock2) {
                    System.out.println("Поток 1 захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2 захватил lock2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Поток 2 был прерван во время ожидания: " + e.getMessage());
                }
                System.out.println("Поток 2 ждет lock1");
                synchronized (lock1) {
                    System.out.println("Поток 2 захватил lock1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

