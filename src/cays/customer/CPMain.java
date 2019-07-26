package cays.customer;

import java.util.concurrent.*;

/**
 * 生产者消费者问题测试
 *
 * @author Chai yansheng
 * @create 2019-07-26 15:09
 **/
public class CPMain {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        BlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>(3);
        ExecutorService executorService = new ThreadPoolExecutor(10, 20,
                90, TimeUnit.SECONDS, workQueue);
            executorService.execute(new Thread(new Producer(buffer), "生产者"));
            executorService.execute(new Thread(new Customer(buffer), "消费者"));
    }
}
