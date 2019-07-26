package cays.customer;


import java.util.concurrent.TimeUnit;

/**
 * 消费者线程
 *
 * @author Chai yansheng
 * @create 2019-07-26 14:50
 **/
public class Customer implements Runnable {
    private Buffer buffer;

    public Customer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(Thread.currentThread().getName() + "等待");
                }
                System.out.println(Thread.currentThread().getName() + "消费：" + buffer.remove());
                buffer.notifyAll();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
