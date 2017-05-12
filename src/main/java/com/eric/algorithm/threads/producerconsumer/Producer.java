package com.eric.algorithm.threads.producerconsumer;

import java.util.Queue;

/**
 * Produce messages and put them into the queue.
 * 
 * Use wait() when queue is full.
 * Use notifyAll() when it has put something into the queue.
 * 
 * @author Eric Leung
 *
 */
public class Producer implements Runnable{

  public static int MAX_SIZE = 5; // max messages allowed in queue.
  Queue<String> queue;
  
  public Producer(Queue<String> queue) {
    this.queue = queue;
  }
  
  @Override
  public void run() {
    
    // This producer will produce 20 messages and the thread terminates.
    for ( int i = 0; i < 20; i ++ ) {
      
      // Get lock for the queue
      synchronized(queue) {
        
        while ( queue.size() == MAX_SIZE ) {
          System.out.println("Producer: Queue full.  Waiting for consumers to dequeue...");
          
          try {
            queue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        
        System.out.println("Producer: Adding: Message " + i);
        queue.add("Message " + i);
        queue.notifyAll();
      }
    }
  }
  
}
