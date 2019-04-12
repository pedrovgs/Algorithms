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
package com.github.pedrovgs.problem7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FibonacciNumbersTest {

  private FibonacciNumbers fibonacciNumbers;

  @Before public void setUp() {
    fibonacciNumbers = new FibonacciNumbers();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesRecursive() {
    fibonacciNumbers.getRecursive(-1);
  }

  @Test public void firstNumberInFibonacciSequenceIsThreeRecursive() {
    assertEquals(1, fibonacciNumbers.getRecursive(1));
  }

  @Test public void fourthNumberInFibonacciSequenceIsThreeRecursive() {
    assertEquals(5, fibonacciNumbers.getRecursive(5));
  }

  @Test public void eleventhNumberInFibonacciSequenceIsRecursive() {
    assertEquals(144, fibonacciNumbers.getRecursive(12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesIterative() {
    fibonacciNumbers.getIterative(-1);
  }

  @Test public void firstNumberInFibonacciSequenceIsThreeIterative() {
    assertEquals(1, fibonacciNumbers.getIterative(1));
  }

  @Test public void fourthNumberInFibonacciSequenceIsThreeIterative() {
    assertEquals(5, fibonacciNumbers.getIterative(5));
  }

  @Test public void eleventhNumberInFibonacciSequenceIsIterative() {
    assertEquals(144, fibonacciNumbers.getIterative(12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesRecursiveWithCatching() {
    fibonacciNumbers.getRecursiveWithCaching(-1);
  }

  @Test public void fourthNumberInFibonacciSequenceIsThreeRecursiveWithCatching() {
    assertEquals(5, fibonacciNumbers.getRecursiveWithCaching(5));
  }

  @Test public void eleventhNumberInFibonacciSequenceIsRecursiveWithCatching() {
    assertEquals(144, fibonacciNumbers.getRecursiveWithCaching(12));
  }
}
