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
package com.github.pedrovgs.problem40;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MoveElementsToPositionsTest {

  private MoveElementsToPositions moveElementsToPosition;

  @Before public void setUp() {
    moveElementsToPosition = new MoveElementsToPositions();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArraysAsInput() {
    moveElementsToPosition.move(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptAnyNumberGreaterThanArrayLengthOrMinorThanOne() {
    int[] input = { 1, 4 };

    moveElementsToPosition.move(input);
  }

  @Test public void shouldMoveElementsToTheCorrectPosition() {
    int[] input = { 2, 3, 1, 0 };

    moveElementsToPosition.move(input);

    assertNumbersAreInTheCorrectPosition(input);
  }

  private void assertNumbersAreInTheCorrectPosition(int[] input) {
    for (int i = 0; i < input.length; i++) {
      assertEquals(i, input[i]);
    }
  }
}
