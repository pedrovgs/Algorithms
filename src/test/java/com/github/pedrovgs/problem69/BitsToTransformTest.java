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
package com.github.pedrovgs.problem69;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BitsToTransformTest {

  private BitsToTransform bitsToTransform;

  @Before public void setUp() {
    bitsToTransform = new BitsToTransform();
  }

  @Test public void shouldReturnZeroIfBothNumbersAreEquals() {
    int numA = 7;
    int numB = 7;

    int numberOfDifferentBits = bitsToTransform.calculate(numA, numB);

    assertEquals(0, numberOfDifferentBits);
  }

  @Test public void shouldClaculateHappyCase() {
    int numA = 5; // 101
    int numB = 1; // 001

    int numberOfDifferentBits = bitsToTransform.calculate(numA, numB);

    assertEquals(1, numberOfDifferentBits);
  }

  @Test public void shouldReturnTheNumberOfDifferentBitsWhenNumAIsLower() {
    int numA = 78; // 1001110
    int numB = 99; // 1100011

    int numberOfDifferentBits = bitsToTransform.calculate(numA, numB);

    assertEquals(4, numberOfDifferentBits);
  }

  @Test public void shouldReturnTheNumberOfDifferentBitsWhenNumAIsGreater() {
    int numA = 99; // 1100011
    int numB = 78; // 1001110

    int numberOfDifferentBits = bitsToTransform.calculate(numA, numB);

    assertEquals(4, numberOfDifferentBits);
  }
}
