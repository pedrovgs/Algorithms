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
package com.github.pedrovgs.problem52;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has
 * sufficient space at the end of the string to hold the additional characters, and that you are
 * given the "true" length of the string. (Note: if implementing in Java, please use a character
 * array so that you can perform this operation in place.)
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReplaceSpaces {

  /**
   * Iterative solution to this problem. Using two pointer we are going to iterate over the input
   * array using one of them and other to store the result in a temporal array. The complexity
   * order of this algorithm in time and space terms is O(N) where N is the number of elements in
   * the array.
   */
  public void replace(char[] input) {
    validateInput(input);

    char[] result = new char[input.length];
    for (int i = 0, j = 0; i < input.length && j < input.length; i++, j++) {
      if (input[i] == ' ') {
        result[j++] = '%';
        result[j++] = '2';
        result[j] = '0';
      } else {
        result[j] = input[i];
      }
    }
    copyArray(result, input);
  }

  private void copyArray(char[] src, char[] destiny) {
    for (int i = 0; i < src.length; i++) {
      destiny[i] = src[i];
    }
  }

  /**
   * Iterative solution with a better performance in spce terms. In time terms, the complexity
   * order of this algorithm is still O(N), the execution time is 2N. In space terms, the
   * complexity order of this algorithm is now O(1) because we are not using any additional data
   * structure to keep a copy of the input array as we are doing in the previous solution.
   */
  public void replace2(char[] input) {
    validateInput(input);

    int i = getLastCharPosition(input);
    for (int j = input.length - 1; i >= 0 && j >= 0; i--, j--) {
      if (input[i] == ' ') {
        input[j--] = '0';
        input[j--] = '2';
        input[j] = '%';
      } else {
        input[j] = input[i];
      }
    }
  }

  private int getLastCharPosition(char[] input) {
    int lastCharPosition = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] != '\0') {
        lastCharPosition = i;
      }
    }
    return lastCharPosition;
  }

  private void validateInput(char[] input) {
    if (input == null) {
      throw new IllegalArgumentException("You can't pass a null array as input parameter.");
    }
  }
}
