package com.github.pedrovgs.problem75;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;

/**
 * Given an array full of integers implement a selection sort algorithm to sort the content inside
 * the array.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SelectionSort extends SortingAlgorithm {

  /**
   * Selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(N^2)
   * time complexity, making it inefficient on large lists, and generally performs worse than the
   * similar insertion sort. Selection sort is noted for its simplicity, and it has performance
   * advantages over more complicated algorithms in certain situations, particularly where
   * auxiliary memory is limited.
   *
   * The algorithm divides the input list into two parts: the sublist of items already sorted,
   * which is built up from left to right at the front (left) of the list, and the sublist of items
   * remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is
   * empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the
   * smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging
   * it with the leftmost unsorted element (putting it in sorted order), and moving the sublist
   * boundaries one element to the right.
   */
  @Override public void sort(int[] numbers) {
    validateInput(numbers);

    int arraySize = numbers.length;
    for (int i = 0; i < arraySize - 1; i++) {

      int index = i;
      for (int j = i + 1; j < arraySize; j++) {
        if (numbers[j] < numbers[index]) index = j;
      }

      swap(numbers, i, index);
    }
  }
}
