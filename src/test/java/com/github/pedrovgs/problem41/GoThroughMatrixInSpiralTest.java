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
package com.github.pedrovgs.problem41;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class GoThroughMatrixInSpiralTest {

  private GoThroughMatrixInSpiral goThroughMatrixInSpiral;

  @Before public void setUp() {
    goThroughMatrixInSpiral = new GoThroughMatrixInSpiral();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullInstancesAsInput() {
    goThroughMatrixInSpiral.go(null);
  }

  @Test public void shouldReturnEmptyArrayIfMatrixIsEmpty() {
    int[][] matrix = { };

    int[] result = goThroughMatrixInSpiral.go(matrix);

    assertEquals(0, result.length);
  }

  @Test public void shouldGoThroughTheMatrixInSpiral() {
    int[][] matrix = {
        { 1, 2, 3, 4, 5, 6 }, { 20, 21, 22, 23, 24, 7 }, { 19, 32, 33, 34, 25, 8 },
        { 18, 31, 36, 35, 26, 9 }, { 17, 30, 29, 28, 27, 10 }, { 16, 15, 14, 13, 12, 11 }
    };

    int[] result = goThroughMatrixInSpiral.go(matrix);

    int[] expected = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36
    };
    assertArrayEquals(expected, result);
  }
}
