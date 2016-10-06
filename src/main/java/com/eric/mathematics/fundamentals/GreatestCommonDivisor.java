package com.eric.mathematics.fundamentals;

import java.math.BigInteger;

/**
 * Greatest common divisor finder using Euclid's algorithm.
 * 
 * gcd(a,0) = a gcd(a,b) = gcd(b, a mod b)
 * 
 * @author eleung
 *
 */
public class GreatestCommonDivisor {

  public static int gcd(int x, int y) {
    if (x == 0) return y;
    if (y == 0) return x;
    if (x == y) return x;

    if (x < y) {
      return gcd(y % x, x);
    } else {
      return gcd(x % y, y);
    }
  }

  public static BigInteger gcd(BigInteger x, BigInteger y) {
    if (x.compareTo(BigInteger.ZERO) == 0) return y;
    if (y.compareTo(BigInteger.ZERO) == 0) return x;
    if (x.compareTo(y) == 0) return x;

    if (x.compareTo(y) < 0) {
      return gcd(y.mod(x), x);
    } else {
      return gcd(x.mod(y), y);
    }
  }
  
}
