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
package com.github.pedrovgs.problem50;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class UniqueCharsTest {

  private UniqueChars uniqueChars;

  @Before public void setUp() {
    uniqueChars = new UniqueChars();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStringsAsInput() {
    uniqueChars.evaluate(null);
  }

  @Test public void shouldReturnFalseIfInputStringIsEmpty() {
    assertTrue(uniqueChars.evaluate(""));
  }

  @Test public void shouldReturnTrueIfInputStringContainsDuplicatedChars() {
    assertFalse(uniqueChars.evaluate("vicente"));
  }

  @Test public void shouldReturnFalseIfInputStringDoesNotContainDuplicatedChars() {
    assertTrue(uniqueChars.evaluate("pedro"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullStringsAsInput2() {
    uniqueChars.evaluate2(null);
  }

  @Test public void shouldReturnTrueIfInputStringIsEmpty2() {
    assertTrue(uniqueChars.evaluate2(""));
  }

  @Test public void shouldReturnFalseIfInputStringContainsDuplicatedChars2() {
    assertFalse(uniqueChars.evaluate2("vicente"));
  }

  @Test public void shouldReturnTrueIfInputStringDoesNotContainDuplicatedChars2() {
    assertTrue(uniqueChars.evaluate2("pedro"));
  }
}
