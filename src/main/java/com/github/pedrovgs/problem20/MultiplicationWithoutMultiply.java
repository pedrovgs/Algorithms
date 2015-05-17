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
package com.github.pedrovgs.problem20;

/**
 * Given two integers passed as parameter, can you write a method to multiply it and return the
 * result without use "*" operator?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MultiplicationWithoutMultiply {

  /**
   * Iterative solution to this problem. This algorithm is based on the multiplication definition
   * as
   * a consecutive sum. The complexity order of this algorithm in time terms is O(N) where N is
   * equals to n1 parameter. In space terms the complexity order of this algorithm is O(1) because
   * we are not using any additional data structure related to the input size.
   */
  public int calculate(int n1, int n2) {
    int result = 0;
    boolean negative = (n1 < 0 && n2 >= 0) || (n2 < 0 && n1 >= 0);
    boolean positive = !negative;
    n1 = Math.abs(n1);
    for (int i = 0; i < n1; i++) {
      if (negative && n2 > 0 || positive && n2 < 0)
        result -= n2;
      else
        result += n2;
    }

    return result;
  }
}
