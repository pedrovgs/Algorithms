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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MoveZerosInArrayTest {

  private MoveZerosInArray moveZeros;

  @Before public void setUp() {
    moveZeros = new MoveZerosInArray();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArraysSorting() {
    moveZeros.moveSorting(null);
  }

  @Test public void shouldWorkWithAnEmptyArraySorting() {
    int[] array = new int[0];

    moveZeros.moveSorting(array);

    assertArrayEquals(new int[0], array);
  }

  @Test public void shouldWorkWithPositiveNegativeZerosArraySorting() {
    int[] array = {-1, 0, 2, 4, 0, -3, -5, 0, 6, -3, 0};

    moveZeros.moveSorting(array);

    assertZerosAtRight(array);
  }

  @Test public void shouldOrganizeAnArrayFullOfZerosSorting() {
    int[] array = { 0, 0, 0, 0, 0 };

    moveZeros.moveUsingTwoPointers(array);

    int[] expected = { 0, 0, 0, 0, 0 };
    assertArrayEquals(expected, array);
  }

  @Test public void shouldOrganizeAnArrayFullOfNonZerosSorting() {
    int[] array = { 1, 1, 1, 1, 1 };

    moveZeros.moveUsingTwoPointers(array);

    int[] expected = { 1, 1, 1, 1, 1 };
    assertArrayEquals(expected, array);
  }

  @Test public void shouldOrganizeAnArrayWithZerosAndNonPositiveIntegersSorting() {
    int[] array = { 1, 0, 2, 3, 0 };

    moveZeros.moveUsingTwoPointers(array);

    assertZerosAtRight(array);
  }

  @Test public void shouldOrganizeAnArrayWithZerosPositiveAndNegativeIntegersSorting() {
    int[] array = { 1, 0, 2, -3, 0, 0, 0, 0, -1 };

    moveZeros.moveUsingTwoPointers(array);

    assertZerosAtRight(array);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullArraysWithTwoPointers() {
    moveZeros.moveUsingTwoPointers(null);
  }

  @Test public void shouldWorkWithAnEmptyArrayWithTwoPointers() {
    int[] array = new int[0];

    moveZeros.moveUsingTwoPointers(array);

    assertArrayEquals(new int[0], array);
  }

  @Test public void shouldOrganizeAnArrayFullOfZerosWithTwoPointers() {
    int[] array = { 0, 0, 0, 0, 0 };

    moveZeros.moveUsingTwoPointers(array);

    int[] expected = { 0, 0, 0, 0, 0 };
    assertArrayEquals(expected, array);
  }

  @Test public void shouldOrganizeAnArrayFullOfNonZerosWithTwoPointers() {
    int[] array = { 1, 1, 1, 1, 1 };

    moveZeros.moveUsingTwoPointers(array);

    int[] expected = { 1, 1, 1, 1, 1 };
    assertArrayEquals(expected, array);
  }

  @Test public void shouldOrganizeAnArrayWithZerosAndNonPositiveIntegersWithTwoPointers() {
    int[] array = { 1, 0, 2, 3, 0 };

    moveZeros.moveUsingTwoPointers(array);

    assertZerosAtRight(array);
  }

  @Test public void shouldOrganizeAnArrayWithZerosPositiveAndNegativeIntegersWithTwoPointers() {
    int[] array = { 1, 0, 2, -3, 0, 0, 0, 0, -1 };

    moveZeros.moveUsingTwoPointers(array);

    assertZerosAtRight(array);
  }

  private void assertZerosAtRight(int[] array) {
    boolean zeroFounded = false;
    for (int i : array) {
      if (zeroFounded) {
        assertEquals(0, i);
      } else if (i == 0) {
        zeroFounded = true;
      }
    }
  }
}
