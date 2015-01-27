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
package com.github.pedrovgs.problem73;

/**
 * Given two integers passed as argument, can you implement the subtract operator using just "+" as
 * arithmetic operator?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SubtractAdding {

  /**
   * Iterative algorithm to resolve this problem. This solution is based on the subtraction
   * definition where the subtraction is defined as the sum of the second number negated.
   */
  public int subtract(int inputA, int inputB) {
    return inputA + negate(inputB);
  }

  private int negate(int number) {
    int increment = number > 0 ? -1 : 1;
    int result = 0;
    while (number != 0) {
      result += increment;
      number += increment;
    }
    return result;
  }
}
