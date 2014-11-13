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
package com.github.pedrovgs.app.problem5;

/**
 * Given two integers passed as parameter, can you write a method to divide the division of that
 * parameters using subtraction operator?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DivideUsingSubtraction {

  /**
   * This algorithm is based on the mathematical property related with the division where a
   * division es a continuous subtraction.
   *
   * In space terms, the complexity of this algorithm is O(1) because we are not using any
   * additional data structure. In time terms, the complexity of this algorithm is O(N) where N is
   * the number of times you can subtract the divider to the dividend.
   */
  public float divideIterative(int dividend, int divider) {
    if (divider == 0) {
      throw new IllegalArgumentException(
          "You can't divide using 0 as divider. That operation is not defined");
    }
    float result = 0;
    while (dividend > divider) {
      dividend -= divider;
      result++;
    }
    float decimalPart = (float) dividend / (float) divider;
    result += decimalPart;
    return result;
  }
}
