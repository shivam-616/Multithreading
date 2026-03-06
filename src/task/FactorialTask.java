package task;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Long> {
    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }
    @Override
    public Long call() throws Exception {
        System.out.println("Factorial of " + number);
        long result = 1;
        for(int i = 1 ; i<=number;i++){
            result *= i;
            Thread.sleep(1300);
        }
        return result;
    }
}
