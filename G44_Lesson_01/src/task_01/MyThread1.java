package task_01;
/*
@date 07.08.2024
@author Sergey Bugaienko
*/

public class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {

            System.out.println(Thread.currentThread().getName() + " - " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
