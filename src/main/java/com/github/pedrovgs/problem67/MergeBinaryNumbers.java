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
package com.github.pedrovgs.problem67;

/**
 * You are given two 32-bit numbers,N and M, and two bit positions, i and j. Write a method to
 * insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j
 * through i have enough space to fit all of M. That is,if M= 10011, you can assume that there are
 * at least 5 bits between j and i. You would not, for example, have j-3 and i=2, because M could
 * not fully fit between bit 3 and bit 2.
 *
 * EXAMPLE:
 *
 * Input:N=16000000000, M=10011, i =2, j =6 Output: N = 10001001100
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MergeBinaryNumbers {

  /**
   * Algorithm based on bits operator to generate different masks used to get the final result
   * after apply the corresponding shift to the input value. In space and time terms the complexity
   * order of this algorithm is O(1).
   */
  public int merge(int n, int m, int i, int j) {
    int maskFullOfOnes = ~0;

    int fullOfOnesBeforeJ = maskFullOfOnes << (j + 1);
    int fullOfOnesAfterI = ((1 << i) - 1);

    int allOnesExceptIandJ = fullOfOnesBeforeJ | fullOfOnesAfterI;

    int clearBitsBetweenIandJ = n & allOnesExceptIandJ;
    int moveMToTheCorrectPosition = m << i;

    return clearBitsBetweenIandJ | moveMToTheCorrectPosition;
  }
}
