package cays.object;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程池开始线程
 * //handler有四个选择：
 * //缺省策略
 * //抛出java.util.concurrent.RejectedExecutionException异常
 * new ThreadPoolExecutor.AbortPolicy();
 * //重试添加当前的任务，他会自动重复调用execute()方法
 * new ThreadPoolExecutor.CallerRunsPolicy();
 * //抛弃旧的任务
 * new ThreadPoolExecutor.DiscardOldestPolicy();
 * //抛弃当前的任务
 * ThreadPoolExecutor.DiscardPolicy();
 * @author Chai yansheng
 * @create 2019-07-26 10:53
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 指定三个长度的工作队列
        LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>(3);
        // 指定线程池参数：核心线程数，线程池最大线程数量，活跃时间，工作队列
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 7,
                90,TimeUnit.SECONDS, workQueue);
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //指定线程池核心数为4，最大线程数量7，工作队列最大放入3个线程，模拟15个线程并发
        for (int i = 0; i < 15; i++) {
            executor.execute(new Thread(new MyThread(), "线程".concat("" + i)));
        }
        System.out.println("活跃线程数量：" + executor.getActiveCount());
        if (workQueue.size() > 0) {
            System.out.println("被阻塞的线程数量：" + workQueue.size());
        }
        executor.shutdown();
    }
    static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("线程运行：" + Thread.currentThread().getName());
        }
    }
}
