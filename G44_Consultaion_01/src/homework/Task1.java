package homework;/*
Дан диапазон чисел: от 1 до 2_000_000 включительно.
Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
Решить данную задачу в один поток.

Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.
Сравнить результаты двух решений - они должны совпадать.
 */

public class Task1 {

    private static int counter;

    public static synchronized void incrementCounter() {
        // Вычисления
        counter++;
    }



    public static void main(String[] args) {
        singleThreadSolution();
        counter = 0;
        twoThreadSolution();

    }

    private static void twoThreadSolution() {
        MyThread myThread1 = new MyThread(1, 1_000_000);
        MyThread myThread2 = new MyThread(1_000_001, 2_000_000);

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value multi thread: " + counter);
        System.out.println(Thread.currentThread().getName() + " closing");


    }

    public static void singleThreadSolution() {

        MyThread myThread = new MyThread(1, 2_000_000);
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value single thread: " + counter);
        System.out.println(Thread.currentThread().getName() + " closing");

    }


}
