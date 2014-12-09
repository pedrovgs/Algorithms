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
package com.github.pedrovgs.problem25;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class AnagramsTest {

  private Anagrams anagrams;

  @Before public void setUp() {
    this.anagrams = new Anagrams();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStrings() {
    anagrams.get(null);
  }

  @Test public void shouldReturnAnEmptyListIfInputStringIsEmpty() {
    assertTrue(anagrams.get("").isEmpty());
  }

  @Test public void shouldCalculateEveryAnagram() {
    String input = "abc";

    List<String> result = anagrams.get(input);
    String[] arrayResult = new String[result.size()];
    result.toArray(arrayResult);

    String[] expectedArray = { "abc", "acb", "bac", "bca", "cab", "cba" };
    assertArrayEquals(expectedArray, arrayResult);
  }
}
