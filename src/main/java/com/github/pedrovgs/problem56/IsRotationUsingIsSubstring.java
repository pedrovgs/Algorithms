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
package com.github.pedrovgs.problem56;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given
 * two strings, s1 and s2, write code to check if s2 isa rotation of s1 using only
 * one call to isSubstring (e.g., "waterbottle" is a rotation of "erbotlewat").
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IsRotationUsingIsSubstring {

  /**
   * Iterative algorithm used to solve this problem. The complexity order of this algorithm in time
   * and space terms is O(N) where N is the sum of input strings lengths. To solve this problem we
   * check if the length of input strings is the same and for strings with the same length we are
   * going to concatenate s1 with s1 check if duplicated s1 contains s2.
   *
   * s1 = waterbottle
   * s2 = erbotlewat
   * s1s1 = waterbottlewaterbottle
   * return "waterbottlewaterbottle".contains(erbotlewat)
   */
  public boolean check(String s1, String s2) {
    validateInput(s1, s2);

    if (haveSameLength(s1, s2)) {
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }
    return false;
  }

  private boolean isSubstring(String s1s2, String s2) {
    return s1s2.contains(s2);
  }

  private void validateInput(String s1, String s2) {
    if (s1 == null || s2 == null) {
      throw new IllegalArgumentException("You can't pass null instances of s1 or s2 as parameter.");
    }
  }

  private boolean haveSameLength(String s1, String s2) {
    return s1.length() == s2.length();
  }
}
