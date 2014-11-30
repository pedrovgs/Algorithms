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
package com.github.pedrovgs.problem9;

/**
 * In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product of all
 * positive integers less than or equal to n. For example:
 *
 * 5! = 5 times 4 times 3 times 2 times  1 = 120.
 *
 * The value of 0! is 1, according to the convention for an empty product.
 *
 * Can you write a method to calculate the factorial of a given positive integer?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Factorial {

  /**
   * Iterative solution for this problem. This version is based on the factorial definition
   * described in the statement and the complexity order in time terms of this solution is O(N)
   * where N is integer passed as argument. In space terms, the complexity order of this algorithm
   * is O(1) because we are not using any additional data structure related to the integer passed
   * as parameter.
   */
  public int getIterative(int n) {
    validateInput(n);

    int result = 1;
    for (int i = n; i >= 2; i--) {
      result *= i;
    }
    return result;
  }

  /**
   * Recursive implementation of the previous algorithm. The complexity order in time and space
   * terms is the same. Take into account that this implementation is not tail recursive.
   */
  public int getRecursive(int n) {
    validateInput(n);

    if (n == 0) {
      return 1;
    } else {
      return n * getRecursive(n - 1);
    }
  }

  /**
   * Tail recursive implementation of the previous algorithm. The complexity order in time and
   * space terms is the same but the resources needed by the CPU to execute this method is lower
   * because this implementation is tail recursive.
   */
  public int getTailRecursive(int n) {
    validateInput(n);
    return getTailRecursiveInner(n, 1);
  }

  private int getTailRecursiveInner(int n, int acc) {
    if (n == 0) {
      return acc;
    } else {
      return getTailRecursiveInner(n - 1, acc * n);
    }
  }

  private void validateInput(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Negative numbers factorial is not defined.");
    }
  }
}
