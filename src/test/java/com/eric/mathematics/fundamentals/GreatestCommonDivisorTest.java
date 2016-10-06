package com.eric.mathematics.fundamentals;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.eric.mathematics.fundamentals.GreatestCommonDivisor;

public class GreatestCommonDivisorTest {

  @Test
  public void testGCDwithInteger() {
    assertEquals(2, GreatestCommonDivisor.gcd(0, 2));
    assertEquals(1, GreatestCommonDivisor.gcd(2, 3));
    assertEquals(2, GreatestCommonDivisor.gcd(2, 4));
    assertEquals(6, GreatestCommonDivisor.gcd(12, 18));
  }
  
  @Test
  public void testGCDwithBigInteger() {
    assertEquals(BigInteger.valueOf(2), GreatestCommonDivisor.gcd(BigInteger.ZERO, BigInteger.valueOf(2)));
    assertEquals(BigInteger.valueOf(1), GreatestCommonDivisor.gcd(BigInteger.valueOf(2), BigInteger.valueOf(3)));
    assertEquals(BigInteger.valueOf(2), GreatestCommonDivisor.gcd(BigInteger.valueOf(2), BigInteger.valueOf(4)));
    assertEquals(BigInteger.valueOf(6), GreatestCommonDivisor.gcd(BigInteger.valueOf(12), BigInteger.valueOf(18)));
    assertEquals(BigInteger.valueOf(1), GreatestCommonDivisor.gcd(new BigInteger("9999999998"), 
                                                                  new BigInteger("9999999999")));
  }
}
