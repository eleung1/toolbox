package com.eric.file;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
 * FileComparator test cases.
 * 
 * @author Eric Leung
 *
 */
public class FileComparatorTest {
  
  @Test
  public void testIsSameFile_sameFile_expectTrue() throws IOException {
    String f1 = "src/test/resources/FileComparator/file1.txt";
    String f2 = "src/test/resources/FileComparator/file1_identical.txt";
    assertTrue(FileComparator.isSameFile(f1, f2));
  }
  
  @Test
  public void testIsSameFile_differentFile_expectFalse() throws IOException {
    String f1 = "src/test/resources/FileComparator/file1.txt";
    String f2 = "src/test/resources/FileComparator/file2.txt";
    assertFalse(FileComparator.isSameFile(f1, f2));
  }
}
