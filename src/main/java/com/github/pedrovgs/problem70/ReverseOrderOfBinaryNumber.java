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
package com.github.pedrovgs.problem70;

/**
 * Given an integer passed as parameter, can you write a method to return the number equivalent to
 * the binary number with the reversed order?
 *
 * For example:
 *
 * Input = 5 = 101
 * Output = 5 = 101
 *
 * Input = 13 = 1101
 * Output = 11 = 1011
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReverseOrderOfBinaryNumber {

  /**
   * Iterative algorithm to solve this problem. Shifting the input number until the value is equals
   * to zero and applying a simple mask we are going to create the reverted order binary number
   * using a constant complexity time in space terms O(1) and a linear complexity order in time
   * terms O(N) where N is equals to the number of digits of the input parameter into a binary
   * representation.
   */
  public int reverse(int number) {
    int result = 0;
    while (number != 0) {
      result <<= 1;
      result |= number & 1;
      number >>= 1;
    }
    return result;
  }
}
