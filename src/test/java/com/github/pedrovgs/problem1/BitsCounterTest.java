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
package com.github.pedrovgs.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BitsCounterTest {

  private BitsCounter bitsCounter;

  @Before public void setUp() {
    bitsCounter = new BitsCounter();
  }

  @Test public void numberOfBitsInOneIsOne() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnString(1));
  }

  @Test public void numberOfBitsInTwoIsOne() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnString(2));
  }

  @Test public void numberOfBitsInThreeIsTwo() {
    assertEquals(2, bitsCounter.countBitsToOneBasedOnString(3));
  }

  @Test public void numberOfBitsInSevenIsThree() {
    assertEquals(3, bitsCounter.countBitsToOneBasedOnBinaryOperators(7));
  }

  @Test public void numberOfBitsIn1990IsSeven() {
    assertEquals(7, bitsCounter.countBitsToOneBasedOnBinaryOperators(1990));
  }

  @Test public void numberOfBitsInOneIsOneBasedOnBinaryOperator() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnBinaryOperators(1));
  }

  @Test public void numberOfBitsInTwoIsOneBasedOnBinaryOperator() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnBinaryOperators(2));
  }

  @Test public void numberOfBitsInThreeIsTwoBasedOnBinaryOperator() {
    assertEquals(2, bitsCounter.countBitsToOneBasedOnBinaryOperators(3));
  }

  @Test public void numberOfBitsInSevenIsThreeBasedOnBinaryOperator() {
    assertEquals(3, bitsCounter.countBitsToOneBasedOnBinaryOperators(7));
  }

  /**
   * A negative number is represented by calculating its complement and adding 1 to
   * the result (Two's complement).
   * eg. ~7 + 1
   */
  @Test
  public void numberOfBitsInNegativeSevenIsThreeBasedOnBinaryOperator() {
    assertEquals(30, bitsCounter.countBitsToOneBasedOnBinaryOperators(-7));
  }

  @Test
  public void numberOfBitsInZero() {
    assertEquals(0, bitsCounter.countBitsToOneBasedOnBinaryOperators(0));
  }

  @Test
  public void numberOfBitsInZeroKernighanMethod() {
    assertEquals(0, bitsCounter.countNumberOfBitsLogN(0));
  }

  @Test
  public void numberOfBitsInNegativeIntegerKernighanMethod() {
    assertEquals(30, bitsCounter.countNumberOfBitsLogN(-7));
  }

  @Test public void numberOfBitsKernighanMethod() {
    assertEquals(3, bitsCounter.countBitsToOneBasedOnBinaryOperators(7));
  }

}
