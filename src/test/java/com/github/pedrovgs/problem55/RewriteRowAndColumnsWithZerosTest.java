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
package com.github.pedrovgs.problem55;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RewriteRowAndColumnsWithZerosTest {

  private RewriteRowAndColumnsWithZeros rewriteMatrix;

  @Before public void setUp() {
    rewriteMatrix = new RewriteRowAndColumnsWithZeros();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullMatrix() {
    rewriteMatrix.rewrite(null);
  }

  @Test public void shouldRewritePositionsEvenWithAOneDimensionMatrix() {
    int[][] matrix = { { 1, 0 }, { } };

    rewriteMatrix.rewrite(matrix);

    int[][] expectedMatrix = { { 0, 0 }, { } };
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test public void shouldNotRewritePositionsWithNonZeroElements() {
    int[][] matrix = { { 1, 1 }, { 1, 1 } };

    rewriteMatrix.rewrite(matrix);

    int[][] expectedMatrix = { { 1, 1 }, { 1, 1 } };
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test public void hsouldRewriteJustCenterRowAndCoulmnWithZeros() {
    int[][] matrix = {
        { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }
    };

    rewriteMatrix.rewrite(matrix);

    int[][] expectedMatrix = {
        { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 }
    };
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test public void shouldRewriteRowAndColumnsWithZeros() {
    int[][] matrix = {
        { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 1 }
    };

    rewriteMatrix.rewrite(matrix);

    int[][] expectedMatrix = {
        { 0, 0, 0 }, { 0, 0, 0 }, { 1, 0, 0 }
    };
    assertArrayEquals(expectedMatrix, matrix);
  }
}
