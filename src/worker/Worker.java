package worker;

import model.Job;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{
    private BlockingQueue<Job> queue;
    public Worker(BlockingQueue<Job> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while(true){
                try{
                    Job job = queue.take();
                    if(job.isPoisonPill()){
                        System.out.println("Poison Pill");
                        break;
                    }
                    job.run();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
