package interviewQA;

public class Multithreading {

    static boolean evenFlag = false;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread odd = new Thread(() -> {

            for (int i = 1; i <= 30; i += 2) {
                synchronized (lock){
                    if (evenFlag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " odd : " + i);
                    evenFlag = true;
                    lock.notify();
                }
            }
        });

        Thread even = new Thread(() -> {

            for (int i = 2; i <= 30; i += 2) {
                synchronized (lock) {
                    if (!evenFlag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " even : " + i);
                    evenFlag = false;
                    lock.notify();
                }
            }
        });

        odd.start();
        even.start();

        even.join();
        odd.join();

    }

}