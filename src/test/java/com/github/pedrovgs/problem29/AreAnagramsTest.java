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
package com.github.pedrovgs.problem29;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class AreAnagramsTest {

  private AreAnagrams areAnagrams;

  @Before public void setUp() {
    areAnagrams = new AreAnagrams();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStringsAsInput() {
    areAnagrams.check(null, null);
  }

  @Test public void shouldReturnTrueIfBothWordsAreEmpty() {
    assertTrue(areAnagrams.check("", ""));
  }

  @Test public void shouldReturnFalseIfOneWordIsEmptyAndTheOtherNo() {
    assertFalse(areAnagrams.check("", "pedro"));
  }

  @Test public void shouldReturnFalseIfWordsAreNotAnagrams() {
    assertFalse(areAnagrams.check("ana", "pedro"));
  }

  @Test public void shouldReturnTrueIfWordsAreAnagrams() {
    assertTrue(areAnagrams.check("ana", "naa"));
  }

  @Test
  public void shouldReturnFalseEvenIfTheSumOfTheCharsIsEqual() throws Exception {
    assertFalse(areAnagrams.check("abc", "efg"));
  }
}
