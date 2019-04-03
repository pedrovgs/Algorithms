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
package com.github.pedrovgs.problem80;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;

/**
 * Given an array full of integers implement a quick sort algorithm to sort the content inside
 * the array.
 *
 * @author jsroyal
 */
public class QuickSort extends SortingAlgorithm {

  /**
   * Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm, serving
   * as a systematic method for placing the elements of an array in order. Developed by Tony Hoare
   * in 1959 and published in 1961, it is still a commonly used algorithm for sorting. When
   * implemented well, it can be about two or three times faster than its main competitors, merge
   * sort and heapsort.
   *
   * Quicksort is a comparison sort, meaning that it can sort items of any type for which a
   * "less-than" relation (formally, a total order) is defined. In efficient implementations it is
   * not a stable sort, meaning that the relative order of equal sort items is not preserved.
   * Quicksort can operate in-place on an array, requiring small additional amounts of memory to
   * perform the sorting.
   *
   * Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n)
   * comparisons to sort n items. In the worst case, it makes O(n2) comparisons, though this
   * behavior is rare.
   */
  @Override public void sort(int[] numbers) {
    validateInput(numbers);
    quickSort(numbers, 0, numbers.length - 1);
  }

  private void quickSort(int[] numbers, int left, int right) {
    if (left < right) {
      int pivotIndex = partition(numbers, left, right);
      quickSort(numbers, left, pivotIndex - 1);  //sort left of pivot
      quickSort(numbers, pivotIndex, right);  //sort right of pivot
    }
  }

  private int partition(int[] numbers, int left, int right) {
    int pivot = numbers[right];
    int i = left - 1;
    for (int j = left; j < right; ++j) {
      if (numbers[j] <= pivot) {
        swap(numbers, ++i, j);
      }
    }
    swap(numbers, ++i, right);
    return i;
  }
}
