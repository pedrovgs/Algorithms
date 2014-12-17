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
package com.github.pedrovgs.problem32;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ContainsTest {

  private Contains contains;

  @Before public void setUp() {
    contains = new Contains();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStringsAsInput() {
    contains.evaluate(null, null);
  }

  @Test public void shouldReturnTrueIfSecondStringContainsFirstString() {
    String word1 = "dro";
    String word2 = "Pedro";

    boolean result = contains.evaluate(word1, word2);

    assertTrue(result);
  }

  @Test public void shouldReturnFalseIfSecondStringDoesNotContainFirstString() {
    String word1 = "ana";
    String word2 = "Pedro";

    boolean result = contains.evaluate(word1, word2);

    assertFalse(result);
  }

  @Test public void shouldBeCaseSensitive() {
    String word1 = "PE";
    String word2 = "Pedro";

    boolean result = contains.evaluate(word1, word2);

    assertFalse(result);
  }
}
