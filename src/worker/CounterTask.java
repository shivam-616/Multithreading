package worker;

import counter.SharedCounter;

public class CounterTask implements Runnable {
    private SharedCounter counter;
    private int loops;

    public CounterTask(int loops, SharedCounter counter) {
        this.counter = counter;
        this.loops = loops;
    }

    @Override
    public void run() {
        for (int i = 0; i < loops; i++) {
            counter.increnment();
        }
    }
}
