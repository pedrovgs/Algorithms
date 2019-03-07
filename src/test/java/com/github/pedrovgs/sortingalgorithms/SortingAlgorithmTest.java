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
package com.github.pedrovgs.sortingalgorithms;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Abstract test used as base test suit for every sorting algorithm in this repository. This is a
 * testing technique used when you want to test the same behaviour in different implementations and
 * provide some additional test case if needed in the test class which extends this base suit test.
 * SortingAlgorithmTest extensions will have to implement "getSortingAlgorithm" method and provide
 * an instance of any SortingAlgorithm implementation.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public abstract class SortingAlgorithmTest {

  private SortingAlgorithm sortingAlgorithm;

  public abstract SortingAlgorithm getSortingAlgorithm();

  @Before public void setUp() {
    sortingAlgorithm = getSortingAlgorithm();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    sortingAlgorithm.sort(null);
  }

  @Test public void shouldNotModifyArrayIfIsAlreadySorted() {
    int[] input = { 1, 2, 3, 4 };

    sortingAlgorithm.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }

  @Test public void shouldSortArrayWhenTheInputDataIsInDescendingOrder() {
    int[] input = { 4, 3, 2, 1 };

    sortingAlgorithm.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }

  @Test public void shouldSortArrayPartiallySorted() {
    int[] input = { 1, 2, 4, 3 };

    sortingAlgorithm.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }

  @Test public void shouldSortArray() {
    int[] input = { 3, 4, 1, 2, 3 };

    sortingAlgorithm.sort(input);

    int[] expectedArray = { 1, 2, 3, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }
}
