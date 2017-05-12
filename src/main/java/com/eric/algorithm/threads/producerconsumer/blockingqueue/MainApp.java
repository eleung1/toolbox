package com.eric.algorithm.threads.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * MainApp using the classic way to start the threads.
 * 
 * @author Eric Leung
 *
 */
public class MainApp {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);
    
    Producer producer = new Producer(blockingQueue);
    Thread producerThread = new Thread(producer);
    
    Consumer consumer = new Consumer("Consumer1", blockingQueue, producerThread);
    Thread consumerThread = new Thread(consumer);
    
    Consumer consumer2 = new Consumer("Consumer2", blockingQueue, producerThread);
    Thread consumerThread2 = new Thread(consumer2);
    
    producerThread.start();
    consumerThread.start();
    consumerThread2.start();
    
    producerThread.join();
    consumerThread.join();
    consumerThread2.join();
    
    System.out.println("Main: We are done!");
  }
}
