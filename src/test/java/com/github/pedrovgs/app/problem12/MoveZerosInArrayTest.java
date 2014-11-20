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
package com.github.pedrovgs.app.problem12;

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

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    moveZeros.move(null);
  }

  @Test public void shouldWorkWithAnEmptyArray() {
    int[] array = new int[0];

    moveZeros.move(array);

    assertArrayEquals(new int[0], array);
  }

  @Test public void shouldOrganizeAnArrayFullOfZeros() {
    int[] array = { 0, 0, 0, 0, 0 };

    moveZeros.move(array);

    int[] expected = { 0, 0, 0, 0, 0 };
    assertArrayEquals(expected, array);
  }

  @Test public void shouldOrganizeAnArrayFullOfNonZeros() {
    int[] array = { 1, 1, 1, 1, 1 };

    moveZeros.move(array);

    int[] expected = { 1, 1, 1, 1, 1 };
    assertArrayEquals(expected, array);
  }

  @Test public void shouldOrganizeAnArrayWithZerosAndNonPositiveIntegers() {
    int[] array = { 1, 0, 2, 3, 0 };

    moveZeros.move(array);

    assertZerosAtRight(array);
  }

  @Test public void shouldOrganizeAnArrayWithZerosPositiveAndNegativeIntegers() {
    int[] array = { 1, 0, 2, -3, 0, 0, 0, 0, -1 };

    moveZeros.move(array);

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
