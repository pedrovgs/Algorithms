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
package com.github.pedrovgs.problem9;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FactorialTest {

  private Factorial factorial;

  @Before public void setUp() {
    this.factorial = new Factorial();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotCalculateFactorialOfNegativeIntegersIterative() {
    factorial.getIterative(-1);
  }

  @Test public void factorialOfZeroEqualsToOneIterative() {
    int result = factorial.getIterative(0);

    assertEquals(1, result);
  }

  @Test public void factorialOfFiveEqualsTo120Iterative() {
    int result = factorial.getIterative(5);

    assertEquals(120, result);
  }

  @Test public void factorialOfSevenEqualsTo5040Iterative() {
    int result = factorial.getIterative(7);

    assertEquals(5040, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotCalculateFactorialOfNegativeIntegersRecursive() {
    factorial.getRecursive(-1);
  }

  @Test public void factorialOfZeroEqualsToOneRecursive() {
    int result = factorial.getRecursive(0);

    assertEquals(1, result);
  }

  @Test public void factorialOfFiveEqualsTo120Recursive() {
    int result = factorial.getRecursive(5);

    assertEquals(120, result);
  }

  @Test public void factorialOfSevenEqualsTo5040Recursive() {
    int result = factorial.getRecursive(7);

    assertEquals(5040, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotCalculateFactorialOfNegativeIntegersTailRecursive() {
    factorial.getTailRecursive(-1);
  }

  @Test public void factorialOfZeroEqualsToOneTailRecursive() {
    int result = factorial.getTailRecursive(0);

    assertEquals(1, result);
  }

  @Test public void factorialOfFiveEqualsTo120TailRecursive() {
    int result = factorial.getTailRecursive(5);

    assertEquals(120, result);
  }

  @Test public void factorialOfSevenEqualsTo5040TailRecursive() {
    int result = factorial.getTailRecursive(7);

    assertEquals(5040, result);
  }
}
