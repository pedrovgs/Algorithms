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
package com.github.pedrovgs.problem53;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CompressStringTest {

  private CompressString compressString;

  @Before public void setUp() {
    compressString = new CompressString();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStringsAsInput() {
    compressString.compress(null);
  }

  @Test public void shouldNotCompressEmptyWords() {
    String wordToCompress = "";

    String result = compressString.compress(wordToCompress);

    assertEquals("", result);
  }

  @Test public void shouldNotCompressWordsWithJustOneChar() {
    String wordToCompress = "a";

    String result = compressString.compress(wordToCompress);

    assertEquals("a", result);
  }

  @Test public void shouldCompressWordsFullOfTheSameChars() {
    String wordToCompress = "aaa";

    String result = compressString.compress(wordToCompress);

    assertEquals("a3", result);
  }

  @Test public void shouldCompressWords() {
    String wordToCompress = "aabcccccaaa";

    String result = compressString.compress(wordToCompress);

    assertEquals("a2bc5a3", result);
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullStringsAsInputAlternative() {
    compressString.compressAlternativeApproach(null);
  }

  @Test public void shouldNotCompressEmptyWordsAlternative() {
    String wordToCompress = "";

    String result = compressString.compressAlternativeApproach(wordToCompress);

    assertEquals("", result);
  }

  @Test public void shouldNotCompressWordsWithJustOneCharAlternative() {
    String wordToCompress = "a";

    String result = compressString.compressAlternativeApproach(wordToCompress);

    assertEquals("a", result);
  }

  @Test public void shouldCompressWordsFullOfTheSameCharsAlternative() {
    String wordToCompress = "aaa";

    String result = compressString.compressAlternativeApproach(wordToCompress);

    assertEquals("a3", result);
  }

  @Test public void shouldCompressWordsAlternative() {
    String wordToCompress = "aabcccccaaa";

    String result = compressString.compressAlternativeApproach(wordToCompress);

    assertEquals("a2bc5a3", result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullStringsAsInputRecursive() {
    compressString.compressRecursive(null);
  }

  @Test public void shouldNotCompressEmptyWordsRecursive() {
    String wordToCompress = "";

    String result = compressString.compressRecursive(wordToCompress);

    assertEquals("", result);
  }

  @Test public void shouldNotCompressWordsWithJustOneCharRecursive() {
    String wordToCompress = "a";

    String result = compressString.compressRecursive(wordToCompress);

    assertEquals("a", result);
  }

  @Test public void shouldCompressWordsFullOfTheSameCharsRecursive() {
    String wordToCompress = "aaa";

    String result = compressString.compressRecursive(wordToCompress);

    assertEquals("a3", result);
  }

  @Test public void shouldCompressWordsRecursive() {
    String wordToCompress = "aabcccccaaa";

    String result = compressString.compressRecursive(wordToCompress);

    assertEquals("a2bc5a3", result);
  }
}
