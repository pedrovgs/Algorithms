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
package com.github.pedrovgs.problem51;

/**
 * Implement a method String reverse(String str) to reverse a String passed as parameter.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReverseString {

  /**
   * Iterative algorithm to solve this problem. The complexity order in time and space terms of
   * this algorithm is O(N) where N is the number of chars in the input String. In time terms is
   * possible to get O(N) because String class uses a char array internally and the complexity
   * order of charAt method is O(1).
   */
  public String reverseIterative(String input) {
    validateInput(input);

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = input.length() - 1; i >= 0; i--) {
      stringBuilder.append(input.charAt(i));
    }
    return stringBuilder.toString();
  }

  /**
   * Tail recursive solution to this problem. This algorithm has the same complexity order in time
   * and space terms than the previous approach.
   */
  public String reverseRecursive(String input) {
    validateInput(input);
    return reverseRecursiveInner(input, input.length() - 1, new StringBuilder());
  }

  private String reverseRecursiveInner(String input, int i, StringBuilder stringBuilder) {
    if (i < 0) {
      return stringBuilder.toString();
    } else {
      stringBuilder.append(input.charAt(i--));
      return reverseRecursiveInner(input, i, stringBuilder);
    }
  }

  private void validateInput(String input) {
    if (input == null) {
      throw new IllegalArgumentException("You can't pass a null String as input parameter.");
    }
  }
}
