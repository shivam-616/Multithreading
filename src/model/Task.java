package model;

public class Task implements Runnable {

    private int taskId;
    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
        try{
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " finished by " + Thread.currentThread().getName());
    }
}
