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
package com.github.pedrovgs.problem45;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FindNthMostRepeatedElementTest {

  private FindNthMostRepeatedElement findNthMostRepeatedElement;

  @Before public void setUp() {
    findNthMostRepeatedElement = new FindNthMostRepeatedElement();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    findNthMostRepeatedElement.find(null, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptInputValuesMinorThanZero() {
    findNthMostRepeatedElement.find(new int[0], 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionIfThereAreNoElementsRepeatedNTimesInTheArrayPassedAsArgument() {
    int[] numbers = { 1, 2, 3 };

    findNthMostRepeatedElement.find(numbers, 2);
  }

  @Test public void shouldFindNthMostRepeatedElement() {
    int[] numbers = { 1, 1, 2, 3, 4, 5, 2, 2, 2, 4, 4, 6, 7, 4, 9, 214, 4, 5, };

    int result = findNthMostRepeatedElement.find(numbers, 2);

    assertEquals(1, result);
  }
}
