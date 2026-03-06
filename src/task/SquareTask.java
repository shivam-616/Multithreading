package task;

import java.util.concurrent.Callable;

public class SquareTask implements Callable<Integer>{
    private final int number;
    public SquareTask(int number) {
        this.number = number;
    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        int result  = number * number;
        System.out.println("Computed square of " + result + "by" + Thread.currentThread().getName());
        return result;
    }
}