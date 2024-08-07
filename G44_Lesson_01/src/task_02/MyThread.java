package task_02;
/*
@date 07.08.2024
@author Sergey Bugaienko
*/

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Task2.counter++;
        }
    }
}
