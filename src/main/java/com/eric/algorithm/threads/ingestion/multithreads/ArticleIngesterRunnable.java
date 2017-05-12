package com.eric.algorithm.threads.ingestion.multithreads;

/**
 * Ingest articles from an external source.
 * 
 * @author Eric Leung
 *
 */
public class ArticleIngesterRunnable implements Runnable {

  @Override
  public void run() {
    for ( int i = 0; i < 100; i ++ ) {
      try {
        
        // Sleep for half a second to imitate actual process delays.
        Thread.sleep(10); 
        
        System.out.println(String.format("Ingested article %d", i));
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
