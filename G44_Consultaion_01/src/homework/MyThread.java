package homework;

public class MyThread  extends Thread{

    private final int rangeStart;
    private final int rangeEnd;

    public MyThread(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        for (int i = rangeStart; i <= rangeEnd ; i++) {
            // Делилось без остатка на 21
            // Число содержало цифру 3
            if (i % 21 == 0 && String.valueOf(i).contains("3")) {
                Task1.incrementCounter();
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ended") ;
    }
}
