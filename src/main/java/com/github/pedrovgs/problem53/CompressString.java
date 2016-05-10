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

      if (isCharRepeated(previousChar, currentChar)) {
        repeatedCharCounter++;
      } else {
        addChar(stringBuilder, previousChar);
        if (repeatedCharCounter > 1) {
          stringBuilder.append(repeatedCharCounter);
          repeatedCharCounter = 1;
        }
        previousChar = currentChar;
      }
    }

    appendLastCharIfNeeded(stringBuilder, repeatedCharCounter, previousChar);

    return stringBuilder.toString();
  }

  /**
   * Time complexity O(n) Space complexity O(n)
   * First while loop for finding repeat groups, and inner while loop is for finding same characters
   */
  public String compressAlternativeApproach(String src) {
    validateInput(src);

    if (src.isEmpty() || src.length() == 1) {
      return src;
    }
    int index = 0;
    int count = 1;
    StringBuilder stringBuilder = new StringBuilder();
    while (index < src.length()) {
      while (index < src.length() - 1) {
        if (src.charAt(index) == src.charAt(index + 1)) {
          index++;
          count++;
        } else {
          stringBuilder.append(src.charAt(index));
          if (count > 1) {
            stringBuilder.append(count);
          }
          count = 1;
          index++;
          break;
        }
      }
      if (index == src.length() - 1) {
        if (src.charAt(index) != src.charAt(index - 1)) {
          stringBuilder.append(src.charAt(index));
        } else {
          stringBuilder.append(src.charAt(index));
          if (count > 1) {
            stringBuilder.append(count);
          }
        }
        index++;
        break;
      }
    }
    return stringBuilder.toString();
  }

  private boolean isCharRepeated(char previousChar, char currentChar) {
    return currentChar == previousChar;
  }

  private void appendLastCharIfNeeded(StringBuilder stringBuilder, int repeatedCharCounter,
      char previousChar) {
    if (repeatedCharCounter > 1) {
      addChar(stringBuilder, previousChar);
      stringBuilder.append(repeatedCharCounter);
    }
  }

  /**
   * Tail recursive solution to this problem. The complexity order in time and space terms of this
   * recursive version is the same than te previous one.
   */
  public String compressRecursive(String src) {
    validateInput(src);

    if (src.length() <= 1) {
      return src;
    }

    return compressRecursiveInner(src, new StringBuilder(), 1, src.charAt(0), 1);
  }

  private String compressRecursiveInner(String src, StringBuilder sb, int i, char previousChar,
      int charCounter) {
    boolean thereIsNoMoreWordToCompress = i == src.length();
    if (thereIsNoMoreWordToCompress) {
      addChar(sb, previousChar);
      addCharCounterIfNeeded(sb, charCounter);
      return sb.toString();
    } else {
      if (isCharRepeated(src.charAt(i), previousChar)) {
        return compressRecursiveInner(src, sb, i + 1, previousChar, charCounter + 1);
      } else {
        addChar(sb, previousChar);
        addCharCounterIfNeeded(sb, charCounter);
        return compressRecursiveInner(src, sb, i + 1, src.charAt(i), 1);
      }
    }
  }

  private void addCharCounterIfNeeded(StringBuilder sb, int charCounter) {
    if (charCounter > 1) {
      sb.append(charCounter);
    }
  }

  private void addChar(StringBuilder sb, char previousChar) {
    sb.append(previousChar);
  }

  private void validateInput(String src) {
    if (src == null) {
      throw new IllegalArgumentException("You can't pass a null String as input parameter.");
    }
  }
}
