import counter.SharedCounter;
import worker.CounterTask;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        CounterTask t1 = new CounterTask(1000000, sharedCounter);
        CounterTask t2 = new CounterTask(1000000, sharedCounter);
        CounterTask t3 = new CounterTask(1000000, sharedCounter);
        CounterTask t4 = new CounterTask(1000000, sharedCounter);
        CounterTask t5 = new CounterTask(1000000, sharedCounter);

        Thread thread1 = new Thread(t1, "worker1");
        Thread thread2 = new Thread(t2, "worker2");
        Thread thread3 = new Thread(t3, "worker3");
        Thread thread4 = new Thread(t4, "worker4");
        Thread thread5 = new Thread(t5, "worker5");


        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("final counter = " + sharedCounter.getValue());
        System.out.println("Expected = 5000000 ");

    }
}