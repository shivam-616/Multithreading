import model.Job;
import producer.Producer;
import task.FactorialTask;
import task.SquareTask;
import worker.Worker;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        BlockingQueue<Job> queue = new LinkedBlockingQueue<>(10);
        ExecutorService pool = Executors.newFixedThreadPool(3);


        Future<Long> f1 = pool.submit(new FactorialTask(5));
        Future<Long> f2 = pool.submit(new FactorialTask(3));
        Future<Long> f3 = pool.submit(new FactorialTask(4));


        System.out.println("Tasks submitted...");

        Long r1 = f1.get();
        Long r2 = f2.get();
        Long r3 = f3.get();

        System.out.println("Results:");
        System.out.println("5! = " + r1);
        System.out.println("4! = " + r2);
        System.out.println("3! = " + r3);


//        Future<Integer> f1 = pool.submit(new SquareTask(4));
//        Producer producer1 = new Producer(queue, 10);
//        Producer producer2 = new Producer(queue, 10);
//        Worker worker1 = new Worker(queue);
//        Worker worker2 = new Worker(queue);
//
//
//
//        pool.submit(worker1);
//        pool.submit(worker2);
//
//        Future<?> f1 = pool.submit(producer1);
//        Future<?> f2 = pool.submit(producer2);
//        try {
//            f1.get();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            f2.get();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        queue.put(Job.poisonPill());
//        queue.put(Job.poisonPill());
//
//        pool.shutdown();
//        pool.awaitTermination(5, TimeUnit.SECONDS);


        System.out.println("System shutdown cleanly.");


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
        pool.shutdown();
    }
}