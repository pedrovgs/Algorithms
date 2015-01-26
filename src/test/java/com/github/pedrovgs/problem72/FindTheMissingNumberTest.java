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
package com.github.pedrovgs.problem72;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FindTheMissingNumberTest {

  private FindTheMissingNumber findMissingNumber;

  @Before public void setUp() {
    findMissingNumber = new FindTheMissingNumber();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullInstances() {
    findMissingNumber.find(null);
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptEmptyArrays() {
    findMissingNumber.find(new int[0]);
  }

  @Test public void shouldFindMissingNumber() {
    int[] numbers = { 0, 1, 2, 4 };

    int missingNumber = findMissingNumber.find(numbers);

    assertEquals(3, missingNumber);
  }
}
