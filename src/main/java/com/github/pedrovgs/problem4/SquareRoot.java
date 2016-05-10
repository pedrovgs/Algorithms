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
package com.github.pedrovgs.problem4;

/**
 * Given an integer passed as parameter, can you write a method to calculate the square root?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SquareRoot {

  private static final double DELTA = 0.1;

  /**
   * Solution implemented to calculate the square root of a given number based on an iterative
   * algorithm.
   *
   * First, we are going to find the first number witch square is greater than the number. Once we
   * have that number we are going to apply a binary search between candidate and candidate +1.
   *
   * The complexity order in space terms of this algorithm is O(1) because we are not using any
   * additional data structure. The complexity order in time terms is more difficult to calculate
   * T(N) = T(N/2) + c  where as N is step length. Which is 1 initially. 0.5 after that. 0.25 after that
   * Stopping condition of this recurrence relation is dependant on delta. If it is 0, then time complexity is infinite
   * So we won't be able to calculate the exact time complexity using master's theorem.
   * Time complexity of this algorithm is inversly proportional to square root of Delta
   * As square root is an irrational number for non square numbers.
   * But here, it will be function of delta and precision of the variables used. Which is difficult to calculate.
   *
   */
  public float calculateSquareRootIterative(int number) {
    //Search first candidate
    float candidate = 1f;
    while (candidate * candidate <= number) {
      candidate++;
    }
    candidate--;
    if (isGoodResultForSqrt(number, candidate * candidate)) {
      return candidate;
    }

    //Apply binary search.
    float top = candidate + 1;
    float bottom = candidate;
    float newCandidate = (top + bottom) / 2;
    float result = newCandidate * newCandidate;
    while (!isGoodResultForSqrt(number, result)) {
      if (result > number) {
        top -= 0.1f;
      } else {
        bottom -= 0.1f;
      }
      newCandidate = (top + bottom) / 2;
      result = newCandidate * newCandidate;
    }
    return Math.abs(newCandidate);
  }

  /**
   * Tail recursive approach to resolve this problem. This algorithm is based on a binary search,
   * as
   * the previous one, but implemented using a tail recursive approach. In space terms, the
   * complexity order of this solution is O(1) and in time terms is similar to the other
   * implementation.
   *
   * This public method uses a private method to hide the algorithm implementation.
   */
  public float calculateSquareRootRecursive(int number) {
    return sqrtRecursiveInner(number, 0, number);
  }

  private static float sqrtRecursiveInner(float n, float low, float high) {
    float sqrt = (low + high) / 2;
    float diff = sqrt * sqrt - n;
    if (diff > DELTA) return sqrtRecursiveInner(n, low, sqrt);
    if (-diff > DELTA) return sqrtRecursiveInner(n, sqrt, high);
    return sqrt;
  }

  private static boolean isGoodResultForSqrt(float number, float result) {
    return Math.abs(result - number) < DELTA;
  }
}
