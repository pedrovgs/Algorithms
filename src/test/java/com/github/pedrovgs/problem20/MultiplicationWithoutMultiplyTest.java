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
  @Test
  public void test1() {
    assertEquals(-2147483648, multiply.calculate(18092019, Integer.MIN_VALUE));
  }

  @Test
  public void test2() {
    assertEquals(-1823452685, multiply.calculate(18092019, -999999999));
  }

  @Test
  public void test3() {
    assertEquals(919590144, multiply.calculate(18092019, -900000000));
  }
  @Test
  public void test4() {
    assertEquals(-919590144, multiply.calculate(18092019, 900000000));
  }
  @Test
  public void test5() {
    assertEquals(1823452685, multiply.calculate(18092019, 999999999));
  }
  @Test
  public void test6() {
    assertEquals(2129391629, multiply.calculate(18092019, Integer.MAX_VALUE));
  }
  @Test
  public void test7() {
    assertEquals(0, multiply.calculate(Integer.MIN_VALUE, 18092019));
  }
  @Test
  public void test8() {
    assertEquals(-1823452685, multiply.calculate(-999999999, 18092019));
  }
  @Test
  public void test9() {
    assertEquals(919590144, multiply.calculate(-900000000, 18092019));
  }
  @Test
  public void test10() {
    assertEquals(-919590144, multiply.calculate(900000000, 18092019));
  }
  @Test
  public void test11() {
    assertEquals(1823452685, multiply.calculate(999999999, 18092019));
  }
  @Test
  public void test12() {
    assertEquals(2129391629, multiply.calculate(Integer.MAX_VALUE, 18092019));
  }
  @Test
  public void test13() {
    assertEquals(1693868201,multiply.calculate(18092019, 18092019));
  }
}
