package task_01;
/*
@date 07.08.2024
@author Sergey Bugaienko
*/

public class Task1 {
    // Создание main-метода: psvm / main

    public static void main(String[] args) {

        // Два способа создания потоков
        // 1. Наследование от класса Thread
        // 2. Реализация интерфейса Runnable


        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        // Это просто вызов метода run. Новые потоки НЕ создаются
//        myThread1.run();
//        myThread2.run();

        // При создании наследованием - вызываем метод start
        myThread1.start();

        // При имплементации - сначала создать объект класса Thread
        // при создании передаем объект нашего класса, имплементирующий Runnable
        // У созданного объекта Thread вызываем метод start()
        Thread thread = new Thread(myThread2);
        // Делаем поток daemon-потоком
        thread.setDaemon(true);
        thread.start();




        // main-поток
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
