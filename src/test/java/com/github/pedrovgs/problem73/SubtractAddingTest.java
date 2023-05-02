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
package com.github.pedrovgs.problem73;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SubtractAddingTest {
  private final static int MAX_INT = Integer.MAX_VALUE;
  private final static int MIN_INT = -MAX_INT;
  private SubtractAdding subtractAdding;

  @Before public void setUp() {
    subtractAdding = new SubtractAdding();
  }

  @Test public void shouldReturnZeroIfInputsAreZero() {
    int inputA = 0;
    int inputB = 0;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(0, result);
  }

  @Test public void shouldReturnZeroIfInputsAreEquals() {
    int inputA = 30;
    int inputB = 30;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(0, result);
  }

  @Test public void shouldReturnAPositiveResultIfFirstInputIsGreaterThanTheSecondOne() {
    int inputA = 33;
    int inputB = 30;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(3, result);
  }

  @Test public void shouldReturnANegativeResultIfFirstInputIsLessThanTheSecondOne() {
    int inputA = 30;
    int inputB = 35;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(-5, result);
  }

  @Test public void shouldCalculateTheCorrectSubtractionIfOneOfTheIntegersIsNegative() {
    int inputA = 30;
    int inputB = -35;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(65, result);
  }

  @Test public void shouldCalculateTheCorrectSubttractionIfBothIntegersAreNegative() {
    int inputA = -30;
    int inputB = -35;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(5, result);
  }
  @Test public void boundaryTest_subtractAdding(){
     assertEquals(0, subtractAdding.subtract(MAX_INT, MAX_INT));
     assertEquals(0, subtractAdding.subtract(MIN_INT, MIN_INT));
     assertEquals(MAX_INT, subtractAdding.subtract(0, MIN_INT));
     assertEquals(MIN_INT, subtractAdding.subtract(0, MAX_INT));
   @Test public void strongBoundaryTest_subtractAdding(){
     assertEquals(0, subtractAdding.subtract(MAX_INT - 1, MAX_INT - 1));
     assertEquals(0, subtractAdding.subtract(MAX_INT + 1, MAX_INT + 1));
     assertEquals(-2, subtractAdding.subtract(MIN_INT - 1, MIN_INT + 1));
     assertEquals(2, subtractAdding.subtract(MIN_INT + 1, MIN_INT - 1)); 
     assertEquals(MIN_INT + 1, subtractAdding.subtract(0, MAX_INT - 1));
     assertEquals(MIN_INT + 2, subtractAdding.subtract(1, MAX_INT - 1));
}
