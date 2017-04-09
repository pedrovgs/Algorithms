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
package com.github.pedrovgs.problem79;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;

/**
 * Given an array full of integers implement a quick sort algorithm to sort the content inside
 * the array.
 *
 * @author jsroyal
 */

/**
   * Quick sort takes advantage for avarage case which O(nlogn);
   * It starts by comparing every two and so on.Final got sort list of the algorithms described here, this is the first that
   * scales well to very large lists, because its worst-case running time is O(n^2). It is also
   * easily applied to lists, not only arrays, as it only requires sequential access, not random
   * access. However, it has additional O(n) space complexity, and involves a large number of
   * copies in simple implementations.
   */

public class QuickSort {

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        while (l < r) {
            while (a[l] < pivot) { //from left move
                l++;               
            }
            while (a[r] > pivot) {  //from right move
                r--;
            }
            if (l <= r) {
                int temp = a[l];        
                a[l] = a[r];
                a[r] = temp;
            }
        }
        return l; //pivot index
    }

    @Override public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pi = partition(a, left, right);  //pi index of pivot
            quickSort(a, left, pi-1);  //sort left of pivot
            quickSort(a, pi, right);  //sort right of pivot               
        }
    }
}
