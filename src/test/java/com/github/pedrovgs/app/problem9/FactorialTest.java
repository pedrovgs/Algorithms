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
package com.github.pedrovgs.app.problem9;

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
  public void shouldNotCalculateFactorialOfNegativeIntegers() {
    factorial.get(-1);
  }

  @Test public void factorialOfZeroEqualsToOne() {
    int result = factorial.get(0);

    assertEquals(1, result);
  }

  @Test public void factorialOfFiveEqualsTo120() {
    int result = factorial.get(5);

    assertEquals(120, result);
  }

  @Test public void factorialOfSevenEqualsTo5040() {
    int result = factorial.get(7);

    assertEquals(5040, result);
  }
}
