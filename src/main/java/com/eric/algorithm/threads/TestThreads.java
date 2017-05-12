package com.eric.algorithm.threads;

/**
 * Thread basics.
 * 
 * @author Eric Leung
 *
 */
public class TestThreads {

  public static void main(String[] args) throws InterruptedException {
    TestThreads testThreads = new TestThreads();
    
    Runnable myRunnable = testThreads.new MyRunnable();
    Thread t1 = new Thread(myRunnable);
    t1.start();
    
    Thread t2 = testThreads.new MyThread();
    t2.start();
    
    t1.join();
    t2.join();
    
    System.out.println("Main thread done!");
    
  }
  
  class MyRunnable implements Runnable {

    @Override
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("MyRunnable is interrupted!");;
      }
      System.out.println("Hello from MyRunnable!");
      
    }
  }
  
  class MyThread extends Thread {
    @Override
    public void run() {
      System.out.println("Hello from MyThread!");
    }
  }
}
