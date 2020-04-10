package com.ruoyi.today.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者
 */
public abstract class MultiThreadExecutor<E> {

    //阻塞队列
    private LinkedBlockingQueue<E> queue;
    //生产者线程计数器
    private CountDownLatch productCountDownLatch;
    //消费者线程计数器
    private CountDownLatch consumerCountDownLatch;
    //生产者线程数量
    private Integer productThreadNum;
    //消费者线程数量
    private Integer consumerThreadNum;
    //队列大小
    private Integer queueSize;

    private void init() {
        queue = new LinkedBlockingQueue<E>(queueSize);
        productCountDownLatch = new CountDownLatch(productThreadNum);
        consumerCountDownLatch = new CountDownLatch(consumerThreadNum);

    }

    protected abstract void product(LinkedBlockingQueue<E> storage);

    protected abstract void consume(LinkedBlockingQueue<E> storage);

    protected void productEnd(LinkedBlockingQueue<E> storage, CountDownLatch countDownLatch) {

    }

    private void startProduct() {
        for (int i = 0; i < productThreadNum; i++) {
            new Thread("product" + i) {

                @Override
                public void run() {

                    product(queue);
                    productEnd(queue, productCountDownLatch);
                    productCountDownLatch.countDown();
                }
            }.start();
        }
    }

    private void startCustomer() {
        for (int i = 0; i < consumerThreadNum; i++) {
            new Thread("customer" + i) {

                @Override
                public void run() {

                    consume(queue);

                    consumerCountDownLatch.countDown();
                }
            }.start();
        }
    }

    public void start(Integer productThreadNum, Integer consumerThreadNum, Integer queueSize) {

        this.consumerThreadNum = consumerThreadNum;
        this.productThreadNum = productThreadNum;
        this.queueSize = queueSize;
        init();
        startProduct();
        startCustomer();
    }

    public void await() throws InterruptedException {
        productCountDownLatch.await();
        consumerCountDownLatch.await();
    }

}
