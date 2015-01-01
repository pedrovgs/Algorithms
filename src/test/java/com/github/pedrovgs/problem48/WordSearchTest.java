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
package com.github.pedrovgs.problem48;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class WordSearchTest {

  private WordSearch wordSearch;

  @Before public void setUp() {
    wordSearch = new WordSearch();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullWordSearch() {
    wordSearch.contains(null, "word");
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullWordsToSearchInTheMatrix() {
    wordSearch.contains(new char[0][0], null);
  }

  @Test public void shouldReturnFalseIfWordSearchIsEmpty() {
    char[][] matrix = {
        { 'a', 'a', 'c', 'd', 'e' }, { 'a', 'd', 'a', 'r', 'c' }, { 'a', 'd', 'a', 'c', 'c' },
        { 'b', 'a', 'c', 'o', 'o' }
    };

    boolean result = wordSearch.contains(matrix, "pedro");

    assertFalse(result);
  }

  @Test public void shouldReturnTrueIfWordToSearchIsInsideWordSearch() {
    char[][] matrix = {
        { 'a', 'a', 'c', 'd', 'e' }, { 'a', 'd', 'a', 'r', 'c' }, { 'a', 'd', 'a', 'c', 'c' },
        { 'b', 'a', 'c', 'o', 'o' }
    };

    boolean result = wordSearch.contains(matrix, "baco");

    assertTrue(result);
  }
}
