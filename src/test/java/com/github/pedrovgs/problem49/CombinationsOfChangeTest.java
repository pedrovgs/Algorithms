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

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CombinationsOfChangeTest {

  private CombinationsOfChange combinationsOfChange;

  @Before public void setUp() {
    combinationsOfChange = new CombinationsOfChange();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    combinationsOfChange.get(null, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptValueToChangeMinorOrEqualsToZero() {
    combinationsOfChange.get(new int[9], -3);
  }

  @Test public void shouldReturnAnEmptyCollectionIfArrayOfMoneysIsEmpty() {
    List<List<Integer>> combinations = combinationsOfChange.get(new int[0], 1);

    assertTrue(combinations.isEmpty());
  }

  @Test public void shouldReturnEveryCombinationOfChange() {
    int[] moneys = { 5, 10, 15, 50 };

    List<List<Integer>> combinations = combinationsOfChange.get(moneys, 60);

    assertContainsChange(combinations, new Integer[] { 50, 10 }, new Integer[] { 15, 15, 15, 15 },
        new Integer[] { 10, 10, 10, 10, 10, 10 },
        new Integer[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 });
  }

  private void assertContainsChange(List<List<Integer>> expectedCombination,
      Integer[]... combinations) {
    assertEquals(expectedCombination.size(), combinations.length);

    for (int i = 0; i < expectedCombination.size(); i++) {
      List<Integer> combination = expectedCombination.get(i);
      assertEquals(combinations[i].length, combination.size());

      for (int j = 0; j < combination.size(); j++) {
        assertEquals(combinations[i][j], combination.get(j));
      }
    }
  }
}

