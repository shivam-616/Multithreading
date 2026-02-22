package model;

public class Job implements Runnable {
    private int jobId;
    private boolean possion;

    public Job(int jobId) {
        this.jobId = jobId;
        this.possion = false;
    }

    public Job(boolean possion) {
        this.jobId = -1;
        this.possion = possion;
    }
     public static Job poisonPill() {
        return new Job(true);
    }
    public  boolean isPoisonPill() {
        return possion;
    }
    @Override
    public void run() {
        if (!possion) {
            System.out.println("Job " + jobId + " processed by " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
