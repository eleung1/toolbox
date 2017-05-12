package com.eric.algorithm.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classic producer/consumer with a queue.
 * 
 * @author Eric Leung
 *
 */
public class MainApp {

  public static void main(String[] args) throws InterruptedException {
    
    // The message queue used by our Producer and Consumer threads.
    Queue<String> messageQueue = new LinkedList<String>();
    
    Producer producer = new Producer(messageQueue);
    Thread producerThread = new Thread(producer);
    
    Consumer consumer = new Consumer("Consumer1", messageQueue, producerThread);
    Consumer consumer2 = new Consumer("Consumer2", messageQueue, producerThread);
    Thread consumerThread = new Thread(consumer);
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
