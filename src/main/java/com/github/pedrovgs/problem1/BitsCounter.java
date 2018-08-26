/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.problem1;

/**
 * Given a positive integer passed as parameter return the number of bits that parameter contains
 * equals to one in a binary representation. For example:
 *
 * Input: 1. Output: 1. Binary representation: 1.
 * Input: 2. Output: 1. Binary representation: 10.
 * Input: 3. Output: 2. Binary representation: 11.
 * Input: 7. Output: 3. Binary representation 111.
 */
public class BitsCounter {

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
    while (n != 0) {
      result += (n & 1) == 1 ? 1 : 0;
      n = n >>> 1;
    }
    return result;
  }

    /**
     * Brian Kernighan's method goes through as many iterations as there are set bits.
     * So if we have a 32-bit word with only the high bit set,
     * then it will only go once through the loop.
     *
     * @param x
     * @return
     */
    public static int countNumberOfBitsLogN(int x) {
        int result = 0;
        while (x != 0) {
            x &= (x - 1);
            result++;
        }
        return result;
    }
}
