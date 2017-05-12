package com.eric.algorithm.threads.ingestion.multithreads;

/**
 * Example of an ingestion process with threads.
 * 
 * Ingesters run in parallel.
 * 
 * @author Eric Leung
 *
 */
public class MainAppMultiThreads {

  public static void main(String[] args) throws InterruptedException {
    long startTime = System.currentTimeMillis();
    
    Thread thread1 = new Thread(new VideoIngesterRunnable());
    Thread thread2 = new Thread(new ArticleIngesterRunnable());
    
    thread1.start();
    thread2.start();
    
    thread1.join();
    thread2.join();
    
    long endTime = System.currentTimeMillis();
    long elaspedTime = endTime - startTime;
    System.out.println(String.format("Elasped time: %d ms.", elaspedTime));
  }
}
