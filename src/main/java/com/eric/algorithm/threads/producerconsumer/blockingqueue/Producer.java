package com.eric.algorithm.threads.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Producer in a blocking queue example.
 * 
 * @author Eric Leung
 *
 */
public class Producer implements Runnable {
  private BlockingQueue<String> queue;
  
  public Producer(BlockingQueue<String> queue) {
    this.queue = queue;
  }
  
  @Override
  public void run() {
    
    for ( int i = 0; i < 20; i++ ) {
      
      // Inserts the specified element into this queue, 
      // waiting if necessary for space to become available.
      try {
        System.out.println("Producer: Adding: Message " + i);
        queue.put("Message " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
}
