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
package com.github.pedrovgs.problem7;

/**
 * In mathematics, the Fibonacci numbers or Fibonacci sequence are the numbers in the following
 * integer sequence:
 *
 * 0,1,1,2,3,5,8,13,21,34.
 *
 * The Fibonacci spiral: an approximation of the golden spiral created by drawing circular arcs
 * connecting the opposite corners of squares in the Fibonacci tiling;this one uses squares of
 * sizes 1, 1, 2, 3, 5, 8, 13, 21, and 34.
 * By definition, the first two numbers in the Fibonacci sequence are 1 and 1, or 0 and 1,
 * depending on the chosen starting point of the sequence, and each subsequent number is the sum of
 * the previous two.
 *
 * Can you write a method to calculate the Nth Fibonacci number?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FibonacciNumbers {

  /**
   * Recursive solution based on Fibonacci sequence definition. F(N) = F(N-1) + F(N-2).
   *
   * The complexity order of this algorithm is O(2^N) where N is integer used as parameter. In space
   * terms, the complexity order of this algorithm is O(1) because we are not using any auxiliary
   * data structure to solve this problem.
   */
  public int getRecursive(int n) {
    validateInput(n);
    if (n == 0 || n == 1) {
      return 1;
    } else {
      return getRecursive(n - 1) + getRecursive(n - 2);
    }
  }

  /**
   * Iterative approach. The complexity order in this algorithm is O(N) where N is the integer used
   * as parameter. In space terms, the complexity order of this algorithm is again O(1).
   */
  public int getIterative(int n) {
    validateInput(n);

    if (n <= 1) {
      return 1;
    }
    int previous = 1;
    int current = 1;
    int element = 0;
    for (int i = 2; i <= n; i++) {
      element = previous + current;
      previous = current;
      current = element;
    }
    return element;
  }

  private static int[] elements = new int[1000];

  /**
   * This version of the recursive algorithm is better in performance terms because we are caching
   * every calculated element to avoid every branch of the recursion the same values. Is faster
   * because one branch is going to take the already calculated value from other branches and when
   * you are going to calculate the 11th value the only thing you have to calculate is to take
   * previous values from the array instead of iterate from nth to 1 and sum every value. I've used
   * a dynamic programming technique.
   *
   * The problem with this algorithm is related with the space complexity which is much bigger than
   * the one used for the previous algorithms. In this case, we have O(N) because we are using an
   * additional data structure to store partial results.
   */
  public int getRecursiveWithCaching(int n) {
    validateInput(n);

    if (n <= 1) {
      return 1;
    } else if (elements[n] != 0) {
      return elements[n];
    }
    elements[n] = getRecursiveWithCaching(n - 1) + getRecursiveWithCaching(n - 2);
    return elements[n];
  }

  private void validateInput(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("You can't use negative values as parameter.");
    }
  }
}
