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

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    splitArray.split(null);
  }

  @Test public void shouldSupportEmptyArrays() {
    int[] array = new int[0];

    splitArray.split(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfPositiveNumbers() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.split(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldWorkWithAnArrayFullOfNegativeNumbers() {
    int[] array = { 1, 2, 1, 3, 4, 6 };

    splitArray.split(array);

    assertNegativeElementsAreBeforePositiveOnes(array);
  }

  @Test public void shouldMoveNegativeElementsToTheLeft() {
    int[] array = { 1, 2, -1, -3, 4, -6 };

    splitArray.split(array);

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
