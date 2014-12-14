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
package com.github.pedrovgs.problem29;

/**
 * Given two Strings passed as parameter, can you write a method to return true if this words are
 * anagrams?
 *
 * For example:
 *
 * Input: ana,naa Output: true
 * Input: pedro,ana Output: false
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class AreAnagrams {

  /**
   * Iterative algorithm to solve this problem. Two words are anagrams just if contains the same
   * number of letters. Using this property, we are going to calculate the number of letters per
   * word and check if the sum is the same. We have used an array of int to represent the letters
   * counter. The complexity order of this algorithm is O(N) where N is the number of letters in
   * the largest word. In space terms, the complexity order of this algorithm is O(M), where M is
   * the number of different letters in the alphabet (we assume ascii, 128 different letters),
   * because we need an additional data structure to store information related to the letters
   * counter.
   */
  public boolean check(String a, String b) {
    if (a == null || b == null) {
      throw new IllegalArgumentException("You can't use null Strings as input.");
    }
    if (a.length() != b.length()) {
      return false;
    }
    int[] lettersA = getLettersAsArray(a);
    int[] lettersB = getLettersAsArray(b);

    int valuesA = getSumOfArray(lettersA);
    int valuesB = getSumOfArray(lettersB);

    return valuesA == valuesB;
  }

  private static int getSumOfArray(int[] array) {
    int count = 0;
    for (int n : array) {
      count += n;
    }
    return count;
  }

  private static int[] getLettersAsArray(String word) {
    int[] letters = new int[128];
    for (char c : word.toCharArray()) {
      letters[c] = letters[c] + 1;
    }
    return letters;
  }
}
