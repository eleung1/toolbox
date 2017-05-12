package com.eric.algorithm.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of a bounded buffer.
 * 
 * Producer should not add to a full buffer.
 * Consumer should not remove from an empty buffer.
 * 
 * @author Eric Leung
 *
 */
public class BoundedBuffer {
  private final Lock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();
  private final Condition notEmpty = lock.newCondition();
  
  Object[] items = new Object[100];
  int putPtr, takePtr, count;
  
  public void put(Object o) throws InterruptedException {
    lock.lock();
    try {
      while ( count == items.length ) {
        // array is full, wait for the notFull signal
        notFull.await();
      }
      items[putPtr] = o;
      
      if ( ++putPtr == items.length ) {
        putPtr = 0; // array is full, move ptr back to front
      }
      
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }
  
  public Object take() throws InterruptedException {
    lock.lock();
    try {
      while ( count == 0 ) {
        // array is empty wait for the notEmpty signal
        notEmpty.await();
      }
      
      Object rc = items[takePtr];
      if ( ++takePtr == items.length ) {
        takePtr = 0;
      }
      
      notFull.signal();
      return rc;
    } finally {
      lock.unlock();
    }
  }
}
