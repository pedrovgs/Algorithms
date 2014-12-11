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
package com.github.pedrovgs.problem27;

/**
 * Given an input String containing a sentence, can you write a method to reverse the content of
 * the sentence without reverse every word?
 *
 * For example:
 *
 * Input: "Pedro Vicente Gómez" Output: "Gómez Vicente Pedro"
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReverseSentence {

  private static final String WORD_SEPARATOR = " ";

  /**
   * Iterative solution for this problem. The complexity order of this algorithm is equals to O(N)
   * where N is the number of chars in the sentence because split method is really expensive. In
   * space terms the complexity order is also O(N) because we are using one StringBuilder to store
   * the result of the algorithm.
   */
  public String reverse(String sentence) {
    if (sentence == null) {
      throw new IllegalArgumentException("Input param can't be null.");
    }
    StringBuilder stringBuilder = new StringBuilder();
    String[] words = sentence.split(WORD_SEPARATOR);
    for (int i = words.length - 1; i >= 0; i--) {
      stringBuilder.append(words[i]);
      if (i != 0) {
        stringBuilder.append(" ");
      }
    }
    return stringBuilder.toString();
  }
}
