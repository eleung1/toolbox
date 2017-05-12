package com.eric.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * File comparator.
 * 
 * @author Eric Leung
 *
 */
public class FileComparator {

  /**
   * Compare the files provided in the params. 
   * 
   * @param filePath1 Path of file number 1.
   * @param filePath2 Path of file number 2.
   * @return TRUE if the 2 files are identical, FALSE otherwise.
   * @throws IOException
   */
  public static boolean isSameFile(String filePath1, String filePath2) throws IOException {
    Path path1 = Paths.get(filePath1);
    Path path2 = Paths.get(filePath2);
    
    byte[] byteArr1 = Files.readAllBytes(path1);
    byte[] byteArr2 = Files.readAllBytes(path2);
    
    return Arrays.equals(byteArr1, byteArr2);
  }
}
