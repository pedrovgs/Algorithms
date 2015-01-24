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
package com.github.pedrovgs.problem69;

/**
 * Given two integers passed as argument, can you write a function to determine the number of bits
 * required to convert integer A to integer B.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BitsToTransform {

  /**
   * Iterative algorithm created to calculate a XOR using the input integers. Once you have the XOR
   * you can iterate through the XOR to count the number of bits equals to 1. To iterate over the
   * integer we are going to modify the value of the XOR integer using & operator with XOR & XOR
   * -1.
   *
   * For example:
   *
   * numA = 001
   * numB = 101
   * XOR  = 100
   *
   * Iteration 1 -> XOR = 100
   * Iteration 2 -> XOR = 100 & 011 = 000 // Loop body not executed.
   */
  public int calculate(int numA, int numB) {
    int differentBits = 0;
    for (int XOR = numA ^ numB; XOR != 0; XOR = XOR & (XOR - 1)) {
      differentBits++;
    }
    return differentBits;
  }
}
