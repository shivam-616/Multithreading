package counter;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public  void increnment() {
        count.incrementAndGet();
    }
    public int getValue(){
        return count.get();
    }

}
