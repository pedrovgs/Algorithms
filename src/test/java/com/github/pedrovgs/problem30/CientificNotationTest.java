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
package com.github.pedrovgs.problem30;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CientificNotationTest {

  private CientificNotation cientificNotation;

  @Before public void setUp() {
    cientificNotation = new CientificNotation();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStringAsInput() {
    cientificNotation.calculate(null);
  }

  @Test public void shouldReturnTheValueOfTheNumber() {
    String number = "9.18E+09";

    long result = cientificNotation.calculate(number);

    assertEquals(9100000000L, result);
  }

  @Test public void shouldTakeIntoAccountNegativeNumbers() {
    String number = "-9.18E+09";

    long result = cientificNotation.calculate(number);

    assertEquals(-9100000000L, result);
  }
}
