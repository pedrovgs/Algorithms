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
package com.github.pedrovgs.problem28;

import com.github.pedrovgs.pair.Pair;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FindSumsTest {

  private FindSums findSums;

  @Before public void setUp() {
    findSums = new FindSums();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    findSums.find(null, 2);
  }

  @Test public void shouldReturnAnEmptyResultIfTheArrayIsEmpty() {
    int[] inputArray = { };

    List<Pair<Integer, Integer>> result = findSums.find(inputArray, 3);

    assertTrue(result.isEmpty());
  }

  @Test public void shouldFindEveryPair() {
    int[] inputArray = { 5, 2, 6, 1, 9 };
    int inputValue = 7;

    List<Pair<Integer, Integer>> result = findSums.find(inputArray, inputValue);

    assertTrue(result.contains(new Pair<Integer, Integer>(5, 2)));
    assertTrue(result.contains(new Pair<Integer, Integer>(6, 1)));
  }

  @Test public void shouldWorkWithNegativeIntegersAsInput() {
    int[] inputArray = { 5, 2, -17, 6, 1, 9 };
    int inputValue = -8;

    List<Pair<Integer, Integer>> result = findSums.find(inputArray, inputValue);

    assertTrue(result.contains(new Pair<Integer, Integer>(-17, 9)));
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArraysLinear() {
    findSums.findLinearComplexityOrder(null, 2);
  }

  @Test public void shouldReturnAnEmptyResultIfTheArrayIsEmptyLinear() {
    int[] inputArray = { };

    List<Pair<Integer, Integer>> result = findSums.findLinearComplexityOrder(inputArray, 3);

    assertTrue(result.isEmpty());
  }

  @Test public void shouldFindEveryPairLinear() {
    int[] inputArray = { 5, 2, 6, 1, 9 };
    int inputValue = 7;

    List<Pair<Integer, Integer>> result =
        findSums.findLinearComplexityOrder(inputArray, inputValue);

    assertTrue(result.contains(new Pair<Integer, Integer>(2, 5)));
    assertTrue(result.contains(new Pair<Integer, Integer>(1, 6)));
  }

  @Test public void shouldWorkWithNegativeIntegersAsInputLinear() {
    int[] inputArray = { 5, 2, -17, 6, 1, 9 };
    int inputValue = -8;

    List<Pair<Integer, Integer>> result =
        findSums.findLinearComplexityOrder(inputArray, inputValue);

    assertTrue(result.contains(new Pair<Integer, Integer>(9, -17)));
  }

  @Test public void shouldWorkWithBoundaryInputValues() {
    int[][] inputArray = {
            {Integer.MAX_VALUE, -2, -3, -4},
            {Integer.MIN_VALUE, 2, 3, 4},
            {Integer.MAX_VALUE - 1, -2, -3, -4},
            {Integer.MIN_VALUE + 1, 2, 3, 4},
            {(Integer.MIN_VALUE + Integer.MAX_VALUE) / 2, 0, 1, 2}
    };
    int[] sumValues = { Integer.MAX_VALUE - 2, Integer.MIN_VALUE + 2, Integer.MAX_VALUE - 3, Integer.MIN_VALUE + 3, 0};

    for (int i = 0; i < inputArray.length; i++) {
      List<Pair<Integer, Integer>> result =
              findSums.findLinearComplexityOrder(inputArray[i], sumValues[i]);

      if (!result.contains(new Pair<Integer, Integer>(inputArray[i][1], inputArray[i][0]))) {
        fail("Fail test number " + i + 1);
      }
    }

    assertTrue(true);
  }

  @Test public void shouldNotWorkWithBadInputValues() {
    int[][] inputArray = {
            {Integer.MAX_VALUE, 2, 3, 4},
            {Integer.MIN_VALUE, -2, 3, 4},
            {Integer.MAX_VALUE - 1, 2, 3, 4},
            {Integer.MIN_VALUE + 1, -2, -3, 4},
            {(Integer.MIN_VALUE + Integer.MAX_VALUE) / 2, 0, 1, 2}
    };
    int[] sumValues = { Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

    for (int i = 0; i < inputArray.length; i++) {
      List<Pair<Integer, Integer>> result =
              findSums.findLinearComplexityOrder(inputArray[i], sumValues[i]);

      if (result.contains(new Pair<Integer, Integer>(inputArray[i][1], inputArray[i][0]))) {
        fail("Fail test number " + i + 1);
      }
    }

    assertTrue(true);
  }

  @Test public void shouldNotWorkWithOverflowNegativeSumValue() {
    int[] inputArray = { Integer.MIN_VALUE, -1, 0, 1, 9 };
    int sumValue = Integer.MIN_VALUE - 1;

    List<Pair<Integer, Integer>> result =
            findSums.findLinearComplexityOrder(inputArray, sumValue);

    assertFalse("Should not allow overflow negative sum input",
            result.contains(new Pair<Integer, Integer>(-1, Integer.MIN_VALUE)));
  }

  @Test public void shouldNotWorkWithOverflowPositiveSumValue() {
    int[] inputArray = { Integer.MAX_VALUE, 1, 0, 1, 9 };
    int sumValue = Integer.MAX_VALUE + 1;

    List<Pair<Integer, Integer>> result =
            findSums.findLinearComplexityOrder(inputArray, sumValue);

    assertFalse("Should not allow overflow positive sum input",
            result.contains(new Pair<Integer, Integer>(1, Integer.MAX_VALUE)));
  }
}
