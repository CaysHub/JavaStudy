package cays.customer;

import java.util.concurrent.TimeUnit;

/**
 * 生产者
 *
 * @author Chai yansheng
 * @create 2019-07-26 15:08
 **/
public class Producer implements Runnable {
    private Buffer buffer;
    private static int item = 0;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isFull()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(Thread.currentThread().getName() + "等待");
                }
                System.out.println(Thread.currentThread().getName() + "生产：" + item);
                buffer.add(item++);
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
