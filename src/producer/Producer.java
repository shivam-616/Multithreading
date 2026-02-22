package producer;

import model.Job;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{

     private BlockingQueue<Job> queue;
     private int noOfjobs;

    public Producer(BlockingQueue<Job> queue  , int noOfjobs){
        this.queue = queue;
        this.noOfjobs = noOfjobs;
    }
    @Override
    public void run(){
        for(int i = 0;i<noOfjobs;i++){
            Job job = new Job(i);
            try{
                queue.put(job);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Produced job " + i);

        }
    }
}
