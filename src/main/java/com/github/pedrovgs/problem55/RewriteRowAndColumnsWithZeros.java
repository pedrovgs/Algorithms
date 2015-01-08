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

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are
 * set to 0.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RewriteRowAndColumnsWithZeros {

  /**
   * Iterative algorithm. The complexity order of this solution in time terms is equals to O(N*M)
   * where N and M are the height and width of the matrix. In space terms, the complexity order of
   * this algorithm has a linear relation to the number of zeros in the matrix and the size of
   * this, at the end, equals to O(N*M) because we are using two auxiliary data structures to keep
   * temporal data which is going to grow following a linear relation to the matrix size.
   */
  public void rewrite(int[][] matrix) {
    validateInput(matrix);

    Set<Integer> rowsToSkip = new HashSet<Integer>();
    Set<Integer> columnsToSkip = new HashSet<Integer>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (shouldPaintRowAndColumn(matrix, i, j, rowsToSkip, columnsToSkip)) {
          rewriteRow(matrix, i, rowsToSkip);
          rewriteColumn(matrix, j, columnsToSkip);
        }
      }
    }
  }

  private void rewriteRow(int[][] matrix, int i, Set<Integer> rowsToSkip) {
    rowsToSkip.add(i);
    for (int x = 0; x < matrix.length; x++) {
      matrix[i][x] = 0;
    }
  }

  private void rewriteColumn(int[][] matrix, int j, Set<Integer> columnsToSkip) {
    columnsToSkip.add(j);
    for (int y = 0; y < matrix[j].length; y++) {
      matrix[y][j] = 0;
    }
  }

  private boolean shouldPaintRowAndColumn(int[][] matrix, int i, int j, Set<Integer> rowsToSkip,
      Set<Integer> columnsToSkip) {
    return matrix[i][j] == 0 && !rowsToSkip.contains(i) && !columnsToSkip.contains(j);
  }

  private void validateInput(int[][] matrix) {
    if (matrix == null) {
      throw new IllegalArgumentException("You can't pass a null insntace as input parameter.");
    }
  }
}
