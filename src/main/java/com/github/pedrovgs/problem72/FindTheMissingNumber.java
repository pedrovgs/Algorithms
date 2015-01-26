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
package com.github.pedrovgs.problem72;

/**
 * An array A contains all the integers from 0 through N, except for one number which is missing.
 * Can you write a method to find that number?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FindTheMissingNumber {

  /**
   * Iterative algorithm to solve this problem. This solution is based on the summation definition,
   * if the array has every element from 0 to N except one, then we can calculate the sum of every
   * element in the summation and the real sum to subtract both values and find the missing number.
   * The complexity order in time terms is O(N) where N is the number o elements in the array. In
   * space terms, the complexity order is O(1) because we are not using any auxiliary data
   * structure with a size related to the input data to resolve this problem.
   */
  public int find(int[] numbers) {
    validateInput(numbers);

    int length = numbers.length;
    int idealSum = length * (length + 1) / 2;
    int sum = calculateSum(numbers);

    int missingNumber = idealSum - sum;
    return missingNumber;
  }

  private int calculateSum(int[] numbers) {
    int sum = 0;
    for (int n : numbers) {
      sum += n;
    }
    return sum;
  }

  private void validateInput(int[] numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("You can't pass a null instance of numbers.");
    }
    if (numbers.length == 0) {
      throw new IllegalArgumentException("You can't pass an empty array");
    }
  }
}
