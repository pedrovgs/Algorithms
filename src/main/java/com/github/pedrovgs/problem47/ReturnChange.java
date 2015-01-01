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
package com.github.pedrovgs.problem47;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of available money and a value as input, can you write a method to return all
 * that change using the less money as possible.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReturnChange {

  /**
   * Iterative solution to this algorithm. This algorithm has a complexity order equals to O(N)
   * where N is the billAmount/maxMoneyValue. At the end, linear to the value passed as parameter.
   */
  public List<Integer> calculate(int[] moneys, int billAmount) {
    validateInputData(moneys, billAmount);

    List<Integer> change = new LinkedList<Integer>();
    while (billAmount > 0 && moneys.length > 0) {
      for (int i = moneys.length - 1; i >= 0; i--) {
        if (billAmount - moneys[i] >= 0) {
          change.add(moneys[i]);
          billAmount -= moneys[i];
          break;
        }
      }
    }
    return change;
  }

  private void validateInputData(int[] moneys, int billAmount) {
    if (moneys == null || moneys.length == 0 || billAmount <= 0) {
      throw new IllegalArgumentException(
          "Review your parameters used as input, you can't use a null or empty array of moneys or "
              + "a bill amount equals or less than zero.");
    }
  }
}
