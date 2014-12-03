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
package com.github.pedrovgs.problem11;

/**
 * Given a integer, can you write a method to transform a given integer to String? Take into
 * account
 * you can receive negative integers.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IntToString {

  /**
   * Algorithm implementation based on the module of a given number and iterate until the number is
   * zero. With this approach we get a complexity order equals to O(N) in time terms where N is the
   * number of digits in the given integer. In space terms, the complexity order is also O(N)
   * because we are using an StringBuilder as auxiliary data structure.
   */
  public String transform(int number) {
    boolean isNegative = false;
    StringBuilder sb = new StringBuilder();
    if (number == 0) {
      return "0";
    } else if (number < 0) {
      isNegative = true;
    }
    number = Math.abs(number);

    while (number > 0) {
      sb.append(number % 10);
      number /= 10;
    }

    if (isNegative) {
      sb.append("-");
    }

    return sb.reverse().toString();
  }
}
