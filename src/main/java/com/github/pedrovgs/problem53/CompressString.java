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
package com.github.pedrovgs.problem53;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CompressString {

  /**
   * Iterative algorithm to resolve this problem. This algorithm has a complexity order in time and
   * space terms equals to O(N) where N is the number of chars in the input String. We've applied
   * two guards, one for null strings and other for input data with 0 or 1 char. The algorithm is
   * based on two pointers to the current and the previous char in the input string and one counter
   * to take the count of how many times the char is inside the word. Whe the algorithm detects a
   * char change, it writes in the StringBuilder the compressed partial result.
   */
  public String compress(String src) {
    validateInput(src);

    if (src.isEmpty() || src.length() == 1) {
      return src;
    }

    StringBuilder stringBuilder = new StringBuilder();
    int repeatedCharCounter = 1;
    char previousChar = src.charAt(0);
    for (int i = 1; i < src.length(); i++) {
      char currentChar = src.charAt(i);
      if (currentChar != previousChar) {
        stringBuilder.append(previousChar);
        if (repeatedCharCounter > 1) {
          stringBuilder.append(repeatedCharCounter);
          repeatedCharCounter = 1;
        }
        previousChar = currentChar;
      } else {
        repeatedCharCounter++;
      }
    }

    if (repeatedCharCounter > 1) {
      stringBuilder.append(previousChar);
      stringBuilder.append(repeatedCharCounter);
    }

    return stringBuilder.toString();
  }

  private void validateInput(String src) {
    if (src == null) {
      throw new IllegalArgumentException("You can't pass a null String as input parameter.");
    }
  }
}
