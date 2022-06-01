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
package com.github.pedrovgs.problem20;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MultiplicationWithoutMultiplyTest {

  private MultiplicationWithoutMultiply multiply;

  @Before public void setUp() {
    multiply = new MultiplicationWithoutMultiply();
  }

  @Test public void anyNumberMultipliedByZeroIsEqualsToZero() {
    assertEquals(0, multiply.calculate(0, 100));
  }
  @Test public void fiveTimesElevenEqualsToFiftyFive() {
    assertEquals(55, multiply.calculate(5, 11));
  }

  @Test public void anyNumberMultipliedByOneShouldReturnTheSameNumber() {
    assertEquals(10, multiply.calculate(1, 10));
  }
  @Test public void anyNumberMultipliedByTwoShouldReturnTheSameNumber() {
    assertEquals(20, multiply.calculate(2, 10));
  }
  @Test public void shouldTakeIntoAccountNegativeNumbers() {
    assertEquals(-15, multiply.calculate(-2, 15));
  }
  @Test public void shouldTakeIntoAccountNegativeNumbers2() {
    assertEquals(-20, multiply.calculate(2, -15));
  }
}
