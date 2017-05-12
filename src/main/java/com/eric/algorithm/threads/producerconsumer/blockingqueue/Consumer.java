package com.eric.algorithm.threads.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Consumer in a BlockingQueue example.
 * 
 * @author Eric Leung
 *
 */
public class Consumer implements Runnable {

  private BlockingQueue<String> queue;
  private String name;
  private Thread producerThread;
  
  public Consumer(String name, BlockingQueue<String> queue, Thread producerThread) {
    this.name = name;
    this.queue = queue;
    this.producerThread = producerThread;
  }
  
  @Override
  public void run() {
    
    // Done when producerThread is terminated and queue is empty
    while ( !(producerThread.getState() == Thread.State.TERMINATED && queue.isEmpty()) ) {
      try {
        // Retrieves and removes the head of this queue, 
        // waiting if necessary until an element becomes available.
        String msg = queue.take();
        System.out.println(name + " consumed message: " + msg);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
