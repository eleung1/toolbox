package com.eric.algorithms.search;

import java.util.Stack;

/**
 * Find the biggest island in an undirected graph.
 * 
 * For example:
 * 1 1 0
 * 0 0 1
 * 1 0 1
 * 
 * The biggest island is the 4 connecting 1s.
 * 
 * @author Eric Leung
 *
 */
public class MatrixIslandFinderDFS {

  static class Node {
    int x;
    int y;
    
    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  public static int findBiggestIsland(int[][] matrix, int n, int m) {
    int[][] visited = new int[n][m];
    
    int maxIslandSize = 0;
    
    // search each unvisited node
    for ( int i = 0; i < n; i ++ ) {
      for ( int j = 0; j < n; j ++ ) {
        if ( visited[i][j] == 0 && matrix[i][j] == 1) {
          int currIslandSize = dfsIslandSizeRecursive(matrix, n, m, i, j, visited);
          
          maxIslandSize = Math.max(maxIslandSize, currIslandSize);
        }
      }
    }
    
    return maxIslandSize;
  }
  
  /**
   * Return the island size starting at coordinate x,y
   * 
   * @param matrix
   * @param n
   * @param m
   * @param x
   * @param y
   * @param visited
   * @return
   */
  public static int dfsIslandSizeRecursive(int[][] matrix, int n, int m, int x, int y, int[][] visited) {
    visited[x][y] = 1;
    
    // visit all 8 neighbours and recursively visit theirs as well
    int islandSize = 1;
    // visit all 8 neighbours and recursively visit theirs
    for( int i = x-1; i <= x+1; i ++ ){
        for ( int j = y-1; j <=y+1; j++ ){
            if ( i >= 0 && i < n 
               && j >= 0 && j < m
               && visited[i][j] == 0
               && matrix[i][j] == 1) {
                islandSize += dfsIslandSizeRecursive(matrix, n, m, i, j, visited);
            }
        }
    }
    
    return islandSize;
  }
  
  public static int dfsIslandSizeIterative(int[][] matrix, int n, int m, int x, int y, int[][] visited) {
    Stack<Node> toExplore = new Stack<Node>();
    toExplore.add(new Node(x,y));
    visited[x][y] = 1;
    
    int islandSize = 0;
    
    while ( !toExplore.isEmpty() ) {
      Node curr = toExplore.pop();
      if ( matrix[curr.x][curr.y] == 1 ) {
        islandSize++;
        
        // Add unvisited adjacent cells to toExplore
        for ( int i = curr.x-1; i <= curr.x+1; i ++ ) {
          for ( int j = curr.y-1; j <= curr.y+1; j ++ ) {
            if ( i >= 0 && i < n && j >= 0 && j < m && visited[i][j] == 0 ) {
              visited[i][j] = 1;
              if ( matrix[i][j] == 1 ) {
                toExplore.push(new Node(i,j));
              }
            }
          }
        }
      } 
    }
    
    return islandSize;
  }
  
  public static void main(String[] args){
    int[][] matrix = new int[][]{ {1,1,0},
                                  {0,0,1},
                                  {1,0,1}};
                                  
    System.out.println(findBiggestIsland(matrix, 3, 3));                             
  }
}
