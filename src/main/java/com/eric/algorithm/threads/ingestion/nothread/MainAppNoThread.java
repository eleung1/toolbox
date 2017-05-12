package com.eric.algorithm.threads.ingestion.nothread;

/**
 * Example of an ingestion process with no threads.
 * 
 * Ingesters run linearly, one after another.
 * 
 * @author Eric Leung
 *
 */
public class MainAppNoThread {

  public static void main(String[] args) {
    
    long startTime = System.currentTimeMillis();
    
    // Ingest videos
    VideoIngester videoIngester = new VideoIngester();
    videoIngester.ingestVideos();
    
    // Ingest articles
    ArticleIngester articleIngester = new ArticleIngester();
    articleIngester.ingestArticles();
    
    long endTime = System.currentTimeMillis();
    long elaspedTime = endTime - startTime;
    System.out.println(String.format("Elasped time: %d ms.", elaspedTime));
  }
}
