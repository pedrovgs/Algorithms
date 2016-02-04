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
package com.github.pedrovgs.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SumBinaryNumberTest {

  private SumBinaryNumbers sumBinaryNumbers;

  @Before public void setUp() {
    this.sumBinaryNumbers = new SumBinaryNumbers();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullInputs() {
    sumBinaryNumbers.sumBinaryNumbersCheating(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptMalformedBinaryNumbers() {
    String n1 = "10";
    String n2 = "2";

    sumBinaryNumbers.sumBinaryNumbersCheating(n1, n2);
  }

  @Test public void zeroPlusZeroEqualsZero() {
    String n1 = "0";
    String n2 = "0";

    String result = sumBinaryNumbers.sumBinaryNumbersCheating(n1, n2);

    assertEquals("0", result);
  }

  @Test public void onePlusOneEqualsTwo() {
    String n1 = "01";
    String n2 = "01";

    String result = sumBinaryNumbers.sumBinaryNumbersCheating(n1, n2);

    assertEquals("10", result);
  }

  @Test public void zeroPlusTwoEqualsTwo() {
    String n1 = "0";
    String n2 = "10";

    String result = sumBinaryNumbers.sumBinaryNumbersCheating(n1, n2);

    assertEquals("10", result);
  }

  @Test public void fivePlusSevenEqualsTwelve() {
    String n1 = "101";
    String n2 = "111";

    String result = sumBinaryNumbers.sumBinaryNumbersCheating(n1, n2);

    assertEquals("1100", result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullInputsBasedOnPowersOfTwo() {
    sumBinaryNumbers.sumBinaryNumbersBasedOnPowersOfTwo(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptMalformedBinaryNumbersBasedOnPowersOfTwo() {
    String n1 = "10";
    String n2 = "2";

    sumBinaryNumbers.sumBinaryNumbersBasedOnPowersOfTwo(n1, n2);
  }

  @Test public void zeroPlusZeroEqualsZeroBasedOnPowersOfTwo() {
    String n1 = "0";
    String n2 = "0";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnPowersOfTwo(n1, n2);

    assertEquals("0", result);
  }

  @Test public void onePlusOneEqualsTwoBasedOnPowersOfTwo() {
    String n1 = "01";
    String n2 = "01";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnPowersOfTwo(n1, n2);

    assertEquals("10", result);
  }

  @Test public void zeroPlusTwoEqualsTwoBasedOnPowersOfTwo() {
    String n1 = "00";
    String n2 = "10";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnPowersOfTwo(n1, n2);

    assertEquals("10", result);
  }

  @Test public void fivePlusSevenEqualsTwelveBasedOnPowersOfTwo() {
    String n1 = "101";
    String n2 = "111";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnPowersOfTwo(n1, n2);

    assertEquals("1100", result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullInputsBasedOnCount() {
    sumBinaryNumbers.sumBinaryNumbersBasedOnCount(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptMalformedBinaryNumbersBasedOnCount() {
    String n1 = "10";
    String n2 = "2";

    sumBinaryNumbers.sumBinaryNumbersBasedOnCount(n1, n2);
  }

  @Test public void zeroPlusZeroEqualsZeroBasedOnCount() {
    String n1 = "0";
    String n2 = "0";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnCount(n1, n2);

    assertEquals(Integer.parseInt("0", 2), Integer.parseInt(result, 2));
  }

  @Test public void onePlusOneEqualsTwoBasedOnCount() {
    String n1 = "01";
    String n2 = "01";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnCount(n1, n2);

    assertEquals("10", result);
  }

  @Test public void zeroPlusTwoEqualsTwoBasedOnCount() {
    String n1 = "00";
    String n2 = "10";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnCount(n1, n2);

    assertEquals(Integer.parseInt("10", 2), Integer.parseInt(result, 2));
  }

  @Test public void fivePlusSevenEqualsTwelveBasedOnCount() {
    String n1 = "101";
    String n2 = "111";

    String result = sumBinaryNumbers.sumBinaryNumbersBasedOnCount(n1, n2);

    assertEquals(Integer.parseInt("1100", 2), Integer.parseInt(result, 2));
  }
}
