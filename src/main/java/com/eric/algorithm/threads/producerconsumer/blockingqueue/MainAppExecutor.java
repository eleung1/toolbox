package com.eric.algorithm.threads.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MainApp using the ExecutorService to execute tasks using a pool of threads.
 * 
 * @author Eric Leung
 *
 */
public class MainAppExecutor {

  public static void main(String[] args) {
    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
    
    Producer producer = new Producer(queue);
    Thread producerThread = new Thread(producer);
    producerThread.start();
    //Consumer consumer = new Consumer("Consumer1", queue, producerThread);
    
    ExecutorService executor = Executors.newFixedThreadPool(2);
    
    for ( int i = 0; i < 5; i ++ ) {
      executor.execute(new Consumer("Consumer" + i, queue, producerThread));
    }
    executor.shutdown();
    
    while(!executor.isTerminated()){
      
    }
    
    System.out.println("Main: Finished!");
  }
}
