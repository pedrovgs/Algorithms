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
package com.github.pedrovgs.problem54;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is an integer, write
 * a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RotateMatrix {

  /**
   * Iterative algorithm to solve this problem. This solution is based on move 4 positions per
   * iteration. With this approach we can reduce the complexity order in space terms from O(N^2) to
   * O(1). In time terms, the complexity order is O(N^2) where N is the height or width of the
   * matrix.
   */
  public void rotate(int[][] matrix) {
    validateInput(matrix);

    int length = matrix.length;
    for (int i = 0; i < length / 2; ++i) {
      int first = i;
      int last = length - 1 - i;
      for (int j = first; j < last; ++j) {
        int offset = j - first;
        int top = matrix[first][j];
        moveLeftToTop(matrix, first, last, j, offset);
        moveBottomToLeft(matrix, first, last, offset);
        moveRithToBottom(matrix, last, j, offset);
        moveTopToRight(matrix, last, j, top);
      }
    }
  }

  private void moveTopToRight(int[][] matrix, int last, int i, int top) {
    matrix[i][last] = top;
  }

  private void moveRithToBottom(int[][] matrix, int last, int i, int offset) {
    matrix[last][last - offset] = matrix[i][last];
  }

  private void moveBottomToLeft(int[][] matrix, int first, int last, int offset) {
    matrix[last - offset][first] = matrix[last][last - offset];
  }

  private void moveLeftToTop(int[][] matrix, int first, int last, int i, int offset) {
    matrix[first][i] = matrix[last - offset][first];
  }

  private void validateInput(int[][] matrix) {
    if (matrix == null) {
      throw new IllegalArgumentException("You can't pass a null instance of matrix as parameter.");
    } else if (matrix.length == 0) {
      throw new IllegalArgumentException(
          "You can't pass an empty instance of matrix as parameter.");
    } else if (matrix.length != matrix[0].length) {
      throw new IllegalArgumentException(
          "You can't pass a matrix with different height and width.");
    }
  }
}
