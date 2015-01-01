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
package com.github.pedrovgs.problem47;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReturnChangeTest {

  private ReturnChange returnChange;

  @Before public void setUp() {
    returnChange = new ReturnChange();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrayOfMoneys() {
    returnChange.calculate(null, 7);
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptEmptyArrayOfMoneys() {
    returnChange.calculate(new int[0], 7);
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptZeroAsInputValue() {
    returnChange.calculate(new int[0], 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativeValuesAsInputValue() {
    returnChange.calculate(new int[0], -7);
  }

  @Test public void shouldReturnChangeUsingJustTheBiggestMoney() {
    int[] moneys = { 5, 10, 15, 50 };

    List<Integer> change = returnChange.calculate(moneys, 200);

    int[] expectedChange = { 50, 50, 50, 50 };
    assertChangeEqualsTo(expectedChange, change);
  }

  @Test public void shouldReturnChangeUsingMoreThanOneMoney() {
    int[] moneys = { 5, 10, 15, 50 };

    List<Integer> change = returnChange.calculate(moneys, 80);

    int[] expectedChange = { 50, 15, 15 };
    assertChangeEqualsTo(expectedChange, change);
  }

  private void assertChangeEqualsTo(int[] expectedChange, List<Integer> change) {
    assertEquals(expectedChange.length, change.size());
    for (int i = 0; i < expectedChange.length; i++) {
      Integer partialChange = expectedChange[i];
      assertEquals(partialChange, change.get(i));
    }
  }
}
