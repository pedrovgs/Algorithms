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
package com.github.pedrovgs.problem8;

/**
 * Given an array full of integers positive or negative write a method to move every negative number
 * to the left and every positive number to the right. Take into account that the order of this
 * elements into the array doesn't care.
 *
 * Input: [1,2,3,-1-,2,-3] Output: [-2,-1,-3,2,3,1]
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SplitArray {

  /**
   * First solution implemented for this problem. It's is based on a sorting algorithm called
   * "Bubble Sorting Algorithm".
   *
   * The complexity order in this O(N^2) where N is number of elements in the array. Is even worst
   * than the bubble sorting algorithm because to check if we have to swap any element is really
   * expensive. In space terms, the complexity order of this algorithm is O(1) because we are not
   * using any additional data structure.
   */
  public void splitSorting(int[] array) {
    if (array == null) {
      throw new IllegalArgumentException("Array passed as parameter can't be null.");
    }

    boolean flag = true;
    while (flag) {
      flag = false;
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
          flag = true;
        }
      }
    }
  }

  /**
   * This solution for the problem is much faster than the previous one. Instead of use a sorting
   * algorithm we are going to go over the array from left to right using two pointers and swapping
   * elements if needed. The complexity order of this algorithm in time terms is O(N) where N is the
   * number of elements in the array. In space terms is O(1) because we are not using any additional
   * data structure.
   */
  public void splitSwappingIterative(int[] array) {
    if (array == null) {
      throw new IllegalArgumentException("Array passed as parameter can't be null.");
    }

    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      boolean shouldChangeLeft = array[left] >= 0;
      boolean shouldChangeRight = array[right] < 0;
      if (shouldChangeLeft && shouldChangeRight) {
        swap(array, left, right);
        left++;
        right--;
      } else {
        if (!shouldChangeLeft) {
          left++;
        } else if (!shouldChangeRight) {
          right--;
        }
      }
    }
  }

  /**
   * Using partition Method of quicksort to split array
   */
  public void splitSwappingPartition(int[] array) {
    if (array == null) {
      throw new IllegalArgumentException("Array passed as parameter can't be null.");
    }

    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      while (array[left] < 0 && left < right) {
        left++;
      }
      while (array[right] >= 0 && left < right) {
        right--;
      }
      if (left < right) {
        swap(array, left, right);
        left++;
        right--;
      }
    }
  }

  /**
   * Tail recursive solution for this problem. This implementation has the same complexity order
   * O(N) and the only change is how we are going to iterate over the array, with the previous
   * implementation we are using a classic iterative approach and with this solution we are using
   * recursion to iterate. In space terms is O(1) because we are not using any additional data
   * structure.
   */
  public void splitSwappingRecursive(int[] array) {
    if (array == null) {
      throw new IllegalArgumentException("Array passed as parameter can't be null.");
    }

    if (array.length == 0) {
      return;
    }

    splitSwappingRecursiveInner(array, 0, array.length - 1);
  }

  private void splitSwappingRecursiveInner(int[] array, int left, int right) {
    if (left < right) {
      boolean shouldChangeLeft = array[left] >= 0;
      boolean shouldChangeRight = array[right] < 0;
      if (shouldChangeLeft && shouldChangeRight) {
        swap(array, left, right);
        splitSwappingRecursiveInner(array, left + 1, right - 1);
      } else {
        if (!shouldChangeLeft) {
          splitSwappingRecursiveInner(array, left + 1, right);
        } else if (!shouldChangeRight) {
          splitSwappingRecursiveInner(array, left, right - 1);
        }
      }
    }
  }

  private void swap(int[] array, int left, int right) {
    int aux = array[right];
    array[right] = array[left];
    array[left] = aux;
  }
}
