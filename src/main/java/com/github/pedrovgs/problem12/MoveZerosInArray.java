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
package com.github.pedrovgs.problem12;

/**
 * Given an array full of integers, can you write a method to move every zero to the right side of
 * the array? The result order of non zero element is not important. Take into account you can find
 * negative numbers inside the array. For example:
 *
 * Input: [1,2,0,4,3] Output: [1,2,3,4,0]
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MoveZerosInArray {

  /**
   * Algorithm implementation based on a sorting algorithm named "Bubble Sorting" modified to work
   * with this problem requirements. Using this sorting algorithm we get a complexity order in time
   * terms equals to O(N^2) where N is the number of elements in the array. In space terms, the
   * complexity order of this algorithm is O(1).
   */
  public void moveSorting(int[] array) {
    validateArray(array);

    boolean swap = true;
    while (swap) {
      swap = false;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] == 0 && array[i + 1] != 0) {
          swap(array, i, i + 1);
          swap = true;
        }
      }
    }
  }

  /**
   * Second implementation for this problem. This implementation is better than the previous one
   * because we have reduced the complexity order of this algorithm in time terms from O(N^2) to
   * O(N). The complexity order in space terms is the same.
   */
  public void moveUsingTwoPointers(int[] array) {
    validateArray(array);

    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      if (array[left] == 0 && array[right] != 0) {
        swap(array, left, right);
      }
      if (array[left] != 0) {
        left++;
      }
      if (array[right] == 0) {
        right--;
      }
    }
  }

  private void validateArray(int[] array) {
    if (array == null) {
      throw new IllegalArgumentException("You can't pass a null array as argument.");
    }
  }

  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
