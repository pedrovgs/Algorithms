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
package com.github.pedrovgs.problem43;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CombinationOfIntegersTest {

  private CombinationOfIntegers combinationOfIntegers;

  @Before public void setUp() {
    combinationOfIntegers = new CombinationOfIntegers();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullInstancesAsInput() {
    combinationOfIntegers.calculate(null);
  }

  @Test public void shouldJustContainEmptySetIfInputSetIsEmpty() {
    Set<Integer> input = new HashSet<Integer>();

    Set<Set<Integer>> result = combinationOfIntegers.calculate(input);

    assertSetContainsSet(result);
  }

  @Test public void shouldCalculateEveryCombination() {
    Set<Integer> input = new HashSet<Integer>();
    input.add(1);
    input.add(2);

    Set<Set<Integer>> result = combinationOfIntegers.calculate(input);

    assertSetContainsSet(result);
    assertSetContainsSet(result, 1);
    assertSetContainsSet(result, 2);
    assertSetContainsSet(result, 1, 2);
  }

  private void assertSetContainsSet(Set<Set<Integer>> result, int... elements) {
    Set<Integer> expected = new LinkedHashSet<Integer>();
    for (int i : elements) {
      expected.add(i);
    }
    assertTrue(result.contains(expected));
  }
}
