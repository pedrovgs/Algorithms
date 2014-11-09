package com.github.pedrovgs.app;

/**
 * Given a positive integer passed as parameter return the number of bits that parameter contains
 * equals to
 * one in a binary representation. For example:
 *
 * Input: 1. Output: 1. Binary representation: 1.
 * Input: 2. Output: 1. Binary representation: 10.
 * Input: 3. Output: 2. Binary representation: 11.
 * Input: 7. Output: 3. Binary representation 111.
 */
public class BitsCounter {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  /**
   * This implementation is based on Strings. Transforming an integer into the binary
   * representation we can obtain an String and use it to count the number of elements equals to
   * '1'. This implementation is slow because it's based on transform the parameter into the binary
   * representation which complexity order is O(N) where N is the number of digits in the parameter
   * binary representation.
   *
   * In addition we have to count the number of elements inside the String obtained and the
   * complexity order of that operation is again O(N).
   *
   * In space terms, the complexity order is O(N) where N is the number of digits used to represent
   * the parameter using binary format. This cost is associated to the usage of an auxiliary String
   * to keep the binary result.
   *
   * To get the binary representation we are going to use a static method of Integer class:
   * Integer.toBinaryString.
   */
  public int countBitsToOneBasedOnString(int n) {
    int result = 0;
    String binaryNumber = Integer.toBinaryString(n);
    for (char c : binaryNumber.toCharArray()) {
      result += c == '1' ? 1 : 0;
    }
    return result;
  }

  /**
   * This implementation is based on binary operators. Instead of transform an integer to binary we
   * are going to use "&" - AND operator - and ">>" - BINARY RIGHT SHIFT OPERATOR - to iterate over
   * the integer passed as parameter checking if the bit at the first position is one or zero.
   *
   * With this implementation we are going to reduce the execution time two times compared with the
   * previous solution. The complexity order is still O(N) where N is the number of digits of the
   * parameter using a binary representation but the execution time is now quite shorter.
   *
   * In space terms, O(1) is the complexity order of this algorithm. We are just using an integer
   * to keep the count of digits to one in binary.
   */
  public int countBitsToOneBasedOnBinaryOperators(int n) {
    int result = 0;
    while (n > 0) {
      result += (n & 1) == 1 ? 1 : 0;
      n = n >> 1;
    }
    return result;
  }
}
