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

  @Test public void anyNumberMultipliedByOneShouldReturnTheSameNumber() {
    assertEquals(7, multiply.calculate(1, 7));
  }

  @Test public void fiveTimesElevenEqualsToFiftyFive() {
    assertEquals(55, multiply.calculate(5, 11));
  }

  @Test public void shouldTakeIntoAccountNegativeNumbers() {
    assertEquals(-14, multiply.calculate(-2, 7));
  }

  /**
   * This tests for Testing HomeWord - Dinh The Hiep - 17020731
   */

  //Testing with both negative n1,n2 (n1 < 0, n2 < 0)
  @Test
  public void test1() {
    assertEquals(5600, multiply.calculate(-70,-80));
  }
  //Testing with n1 > 0, n2 >0
  @Test
  public void test2() {
    assertEquals(484, multiply.calculate(44, 11));
  }
  //Testing with n1 > 0, n2 < 0
  @Test
  public void test3() {
    assertEquals(-1500, multiply.calculate(500, -3));
  }
  //Testing with n2 > 0, n1 < 0
  @Test
  public void test4() {
    assertEquals(-4500, multiply.calculate(3, -1500));
  }

}
