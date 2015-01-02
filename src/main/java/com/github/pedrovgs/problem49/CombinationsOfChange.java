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
package com.github.pedrovgs.problem49;

import com.github.pedrovgs.problem47.ReturnChange;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of moneys and one amount to change, can you write a method to calculate every
 * possible return change using all possible combinations of moneys minimizing the number of moneys
 * to return?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CombinationsOfChange {

  private final ReturnChange returnChange;

  public CombinationsOfChange() {
    this.returnChange = new ReturnChange();
  }

  /**
   * Combination of an iterative and recursive approach to resolve this problem. We are using
   * ReturnChange problem to create this algorithm. The complexity order of this algorithm in space
   * terms is equals to O(N) where N is the number of possible combinations. In time terms, the
   * complexity order is equals to O(N*M) where N is the number of moneys in the array and M the
   * complexity order of ReturnChange algorithm.
   */
  public List<List<Integer>> get(int[] availableChange, int value) {
    validateInputData(availableChange, value);

    List<List<Integer>> changeCombinations = new LinkedList<List<Integer>>();
    for (int i = 0; i < availableChange.length; i++) {
      int[] availableMoneys = Arrays.copyOfRange(availableChange, 0, availableChange.length - i);
      List<Integer> change = getChange(availableMoneys, value);
      changeCombinations.add(change);
    }
    return changeCombinations;
  }

  private List<Integer> getChange(int[] availableMoneys, int value) {
    return returnChange.calculate(availableMoneys, value);
  }

  private void validateInputData(int[] availableChange, int value) {
    if (availableChange == null || value <= 0) {
      throw new IllegalArgumentException(
          "You can't pass a null array or a value minor or equals to zero as argument.");
    }
  }
}
