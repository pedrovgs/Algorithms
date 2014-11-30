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
package com.github.pedrovgs.problem5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DivideUsingSubtractionTest {

  private static final double DELTA = 0.1;

  private DivideUsingSubtraction divideUsingSubtraction;

  @Before public void setUp() {
    this.divideUsingSubtraction = new DivideUsingSubtraction();
  }

  @Test(expected = IllegalArgumentException.class)
  public void anyNumberDividedByZeroIsNotDefinedIterative() {
    int dividend = 100;
    int divider = 0;

    divideUsingSubtraction.divideIterative(dividend, divider);
  }

  @Test public void fourDividedByTwoEqualsToTwoIterative() {
    int dividend = 4;
    int divider = 2;

    float result = divideUsingSubtraction.divideIterative(dividend, divider);

    assertEquals(2, result, DELTA);
  }

  @Test public void fiveDividedByTwoEqualsToTwoPointFiveIterative() {
    int dividend = 5;
    int divider = 2;

    float result = divideUsingSubtraction.divideIterative(dividend, divider);

    assertEquals(2.5, result, DELTA);
  }

  @Test public void sixtyDividedByTwelveEqualsToFiveIterative() {
    int dividend = 60;
    int divider = 12;

    float result = divideUsingSubtraction.divideIterative(dividend, divider);

    assertEquals(5, result, DELTA);
  }

  @Test(expected = IllegalArgumentException.class)
  public void anyNumberDividedByZeroIsNotDefinedRecursive() {
    int dividend = 100;
    int divider = 0;

    divideUsingSubtraction.divideRecursive(dividend, divider);
  }

  @Test public void fourDividedByTwoEqualsToTwoRecursive() {
    int dividend = 4;
    int divider = 2;

    float result = divideUsingSubtraction.divideRecursive(dividend, divider);

    assertEquals(2, result, DELTA);
  }

  @Test public void fiveDividedByTwoEqualsToTwoPointFiveRecursive() {
    int dividend = 5;
    int divider = 2;

    float result = divideUsingSubtraction.divideRecursive(dividend, divider);

    assertEquals(2.5, result, DELTA);
  }

  @Test public void sixtyDividedByTwelveEqualsToFiveRecursive() {
    int dividend = 60;
    int divider = 12;

    float result = divideUsingSubtraction.divideRecursive(dividend, divider);

    assertEquals(5, result, DELTA);
  }
}
