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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SplitArrayTest {

  SplitArray splitArray;

  @Before public void setUp() {
    splitArray = new SplitArray();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArraysSorting() {
    splitArray.splitSorting(null);
  }

  @Test public void shouldSupportEmptyArraysSorting() {
    int[] array = new int[0];

    splitArray.splitSorting(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfPositiveNumbersSorting() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSorting(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfNegativeNumbersSorting() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSorting(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldMoveNegativeElementsToTheLeftSorting() {
    int[] array = { 1, 2, -1, -3, 4, -6 };

    splitArray.splitSorting(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldMoveNegativeElementsToTheLeftWithWithMoreNegativeElementsSorting() {
    int[] array = { 1, -2, -1, -3, 4, -6 };

    splitArray.splitSorting(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullArraysWithTwoPointersIterative() {
    splitArray.splitSwappingIterative(null);
  }

  @Test public void shouldSupportEmptyArraysWithTwoPointersIterative() {
    int[] array = new int[0];

    splitArray.splitSwappingIterative(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfPositiveNumbersWithTwoPointersIterative() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSwappingIterative(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfNegativeNumbersWithTwoPointersIterative() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSwappingIterative(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldMoveNegativeElementsToTheLeftWithTwoPointersIterative() {
    int[] array = { 1, 2, -1, -3, 4, -6 };

    splitArray.splitSwappingIterative(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test
  public void shouldMoveNegativeElementsToTheLeftWithWithMoreNegativeElementsTwoPointersIterative() {
    int[] array = { 1, -2, -1, -3, 4, -6 };

    splitArray.splitSwappingIterative(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullArraysWithPartition() {
    splitArray.splitSwappingPartition(null);
  }

  @Test public void shouldSupportEmptyArraysWithPartition() {
    int[] array = new int[0];

    splitArray.splitSwappingPartition(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfPositiveNumbersWithPartition() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSwappingPartition(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfNegativeNumbersWithPartition() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSwappingPartition(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldMoveNegativeElementsToTheLeftWithPartition() {
    int[] array = { 1, 2, -1, -3, 4, -6 };

    splitArray.splitSwappingPartition(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test
  public void shouldMoveNegativeElementsToTheLeftWithWithMoreNegativeElementsWithPartition() {
    int[] array = { 1, -2, -1, -3, 4, -6 };

    splitArray.splitSwappingPartition(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullArraysWithTwoPointersRecursive() {
    splitArray.splitSwappingRecursive(null);
  }

  @Test public void shouldSupportEmptyArraysWithTwoPointersRecursive() {
    int[] array = new int[0];

    splitArray.splitSwappingRecursive(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfPositiveNumbersWithTwoPointersRecursive() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSwappingRecursive(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfNegativeNumbersWithTwoPointersRecursive() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.splitSwappingRecursive(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldMoveNegativeElementsToTheLeftWithTwoPointersRecursive() {
    int[] array = { 1, 2, -1, -3, 4, -6 };

    splitArray.splitSwappingRecursive(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test
  public void shouldMoveNegativeElementsToTheLeftWithWithMoreNegativeElementsTwoPointersRecursive() {
    int[] array = { 1, -2, -1, -3, 4, -6 };

    splitArray.splitSwappingRecursive(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  private void assertNegativeElementsAreBeforePositiveOnes(int[] array) {
    if (array.length != 0) {
      boolean foundPositiveNumbers = false;
      for (int element : array) {
        if (foundPositiveNumbers) {
          assertTrue(element >= 0);
        } else if (element >= 0) {
          foundPositiveNumbers = true;
        }
      }
    }
  }
}
