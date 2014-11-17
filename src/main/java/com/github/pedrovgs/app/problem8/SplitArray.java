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
package com.github.pedrovgs.app.problem8;

/**
 * Given an array full of integers positive or negative write a method to move every negative
 * number to the left and every positive number to the right. Take into account that the order of
 * this elements into the array doesn't care.
 *
 * Input: [1,2,3,-1-,2,-3]
 * Output: [-2,-1,-3,2,3,1]
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
   * expensive.
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

  private void swap(int[] array, int left, int right) {
    int aux = array[right];
    array[right] = array[left];
    array[left] = aux;
  }
}
