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
package com.github.pedrovgs.problem34;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings, can you write a method to return return just words that matches with
 * a pattern containing the "." regular expression.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DotRegularExpression {

  /**
   * Iterative and recursive solution to solve this problem. The complexity order of this algorithm
   * is O(N*M) where N is the number of elements in the input array and M the complexity order of
   * the method written below. In space terms the complexity order of this algorithm is O(N) because
   * we are using an array to keep the result of the problem.
   */
  public String[] evaluate(String[] words, String pattern) {
    if (words == null || pattern == null) {
      throw new IllegalArgumentException("You can't pass null objects as input.");
    }
    List<String> result = new ArrayList<String>();
    for (String word : words) {
      if (matchDotRegularExpression(word, pattern)) {
        result.add(word);
      }
    }
    return result.toArray(new String[result.size()]);
  }

  /**
   * The complexity order of this recursive algorithm is O(N) where N is the number of letters in
   * the word.
   */
  private static boolean matchDotRegularExpression(String word, String pattern) {
    if (Math.abs(word.length() - pattern.length()) > 1) {
      return false;
    } else if (word.isEmpty() && pattern.isEmpty()) {
      return true;
    } else if (pattern.charAt(0) == '.') {
      return matchDotRegularExpression(word.substring(1), pattern.substring(1));
    } else {
      boolean partialMatch = word.charAt(0) == pattern.charAt(0);
      return partialMatch && matchDotRegularExpression(word.substring(1), pattern.substring(1));
    }
  }
}
