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
package com.github.pedrovgs.problem34;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DotRegularExpressionTest {

  private DotRegularExpression dotRegularExpression;

  @Before public void setUp() {
    dotRegularExpression = new DotRegularExpression();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullArrayOrPatternAsInput() {
    dotRegularExpression.evaluate(null, null);
  }

  @Test public void shouldReturnAnEmptyArrayIfTheArrayIsEmpty() {
    String pattern = "p.d";
    String[] words = { };

    String[] result = dotRegularExpression.evaluate(words, pattern);

    assertEquals(0, result.length);
  }

  @Test public void shouldReturnAnEmptyArrayIfPatternDoesNotMatch() {
    String pattern = "p.d";
    String[] words = { "ana", "test1", "test2" };

    String[] result = dotRegularExpression.evaluate(words, pattern);

    assertEquals(0, result.length);
  }

  @Test public void shouldReturnAnArrayWithMatches() {
	    String pattern = "p.d";
	    // a "pd" nem jo neki.
	    String[] words = { "pod", "pid", "pat", "por", "pwd", "p�d", "p\nd", "pd"};

	    String[] result = dotRegularExpression.evaluate(words, pattern);
	    String[] expectedResult = { "pod", "pid", "pwd" , "p�d", "p\nd", "pd"};
	    assertArrayEquals(expectedResult, result);
	  }
  @Test public void shouldReturnAnArrayWithMatches2() {
	    String pattern = "pe.d";
	    String[] words = { "peod", "peid", "pat", "por", "pwd", "p�d", "p\nd", "ped"};

	    String[] result = dotRegularExpression.evaluate(words, pattern);
	    String[] expectedResult = { "peod", "peid"};
	    assertArrayEquals(expectedResult, result);
	  }
  
}
