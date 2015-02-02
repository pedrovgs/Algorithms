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
package com.github.pedrovgs.problem76;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;

/**
 * Given an array full of integers implement a insert sort algorithm to sort the content inside
 * the array.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class InsertionSort extends SortingAlgorithm {

  /**
   * Insertion sort is a simple sorting algorithm that is relatively efficient for small lists and
   * mostly sorted lists, and often is used as part of more sophisticated algorithms. It works by
   * taking elements from the list one by one and inserting them in their correct position into a
   * new sorted list. In arrays, the new list and the remaining elements can share the array's
   * space, but insertion is expensive, requiring shifting all following elements over by one.
   */
  @Override public void sort(int[] numbers) {
    validateInput(numbers);

    int i;
    for (i = 1; i < numbers.length; i++) {
      int tmp = numbers[i];
      int j = i;
      while (j > 0 && numbers[j - 1] > tmp) {
        numbers[j] = numbers[j - 1];
        j--;
      }
      numbers[j] = tmp;
    }
  }
}
