package com.eric.algorithm.threads.producerconsumer;

import java.util.Queue;

/**
 * Consumer of the queue.
 * 
 * @author Eric Leung
 *
 */
public class Consumer implements Runnable {

  private Queue<String> queue;
  private Thread producerThread;
  private String name;
  
  public Consumer(String name, Queue<String> queue, Thread producerThread) {
    this.name = name;
    this.queue = queue;
    this.producerThread = producerThread;
  }
  
  @Override
  public void run() {
    
    // Exit if producerThread has terminated AND the queue is empty.
    while ( !(producerThread.getState() == Thread.State.TERMINATED && queue.isEmpty()) ) {
      synchronized(queue) {
        
        // Queue is empty.  Wait for new messages.
        while ( queue.isEmpty() ) {
          
          if ( producerThread.getState() == Thread.State.TERMINATED ) {
            System.out.println(name + ": Queue is empty.  Producer terminated. Terminating!");
            return;
          }
          
          System.out.println(name + ": Queue is empty.  Waiting for producer to enqueue new messages.");
          try {
            queue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        
        // Reaching this point means the producer has put new messages into the queue.
        String msg = queue.remove();
        
        // Notify producer we have consumed messages from the queue.
        queue.notify();
        System.out.println(name + " consumed message: " + msg);
        
      }
    }
    
  }
  
}
