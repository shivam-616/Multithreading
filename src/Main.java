import model.Job;
import producer.Producer;
import worker.Worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Job> queue = new LinkedBlockingQueue<>(10);
        Producer producer1 = new Producer(queue, 10);
        Producer producer2 = new Producer(queue, 10);

        Worker worker1 = new Worker(queue);
        Worker worker2 = new Worker(queue);

//        ArrayList<Thread> flow = new ArrayList<>();
        Thread thread1 = new Thread(worker1, "worker1");
        Thread thread2 = new Thread(worker2, "worker2");
        Thread thread3 = new Thread(producer1, "producer1");
        Thread thread4 = new Thread(producer2, "producer2");
        thread3.start();
        thread4.start();

        thread2.start();
        thread1.start();


        thread3.join();


        thread4.join();


        queue.put(Job.poisonPill());


        queue.put(Job.poisonPill());


        thread1.join();
        thread2.join();

//        for (Thread t : flow) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


//        SharedCounter sharedCounter = new SharedCounter();
//        CounterTask t1 = new CounterTask(1000000, sharedCounter);
//        CounterTask t2 = new CounterTask(1000000, sharedCounter);
//        CounterTask t3 = new CounterTask(1000000, sharedCounter);
//        CounterTask t4 = new CounterTask(1000000, sharedCounter);
//        CounterTask t5 = new CounterTask(1000000, sharedCounter);
//
//        Thread thread1 = new Thread(t1, "worker1");
//        Thread thread2 = new Thread(t2, "worker2");
//        Thread thread3 = new Thread(t3, "worker3");
//        Thread thread4 = new Thread(t4, "worker4");
//        Thread thread5 = new Thread(t5, "worker5");
//
//
//        ArrayList<Thread> threads = new ArrayList<>();
//        threads.add(thread1);
//        threads.add(thread2);
//        threads.add(thread3);
//        threads.add(thread4);
//        threads.add(thread5);
//
//        for (Thread t : threads) {
//            t.start();
//        }
//        for (Thread t : threads) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("final counter = " + sharedCounter.getValue());
//        System.out.println("Expected = 5000000 ");

    }
}