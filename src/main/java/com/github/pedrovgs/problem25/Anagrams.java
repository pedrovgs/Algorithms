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

import java.util.LinkedList;
import java.util.List;

/**
 * Given a String passed as parameter, can you write a method to calculate input word anagrams?
 *
 * An anagram is a type of word play, the result of rearranging the letters of a word or phrase to
 * produce a new word or phrase, using all the original letters exactly once; for example Torchwood
 * can be rearranged into Doctor Who. The original word or phrase is known as the subject of the
 * anagram. Anagrams are often used as a form of mnemonic device as well.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Anagrams {

  /**
   * Combination of recursion and one iterative approach to resolve this problem. The complexity of
   * this algorithm is O(N!) where N is the size of the input. In space terms the complexity order
   * is related to the number of permutations equals to O(N!) where N is the number of chars in the
   * input string.
   */
  public List<String> get(String input) {
    List<String> result = null;
    if (input == null) {
      throw new IllegalArgumentException("You can't pass a null String as input.");
    } else if (input.isEmpty()) {
      result = new LinkedList<String>();
    } else {
      result = getAnagramsInner("", input);
    }
    return result;
  }

  private List<String> getAnagramsInner(String prefix, String word) {
    List<String> anagrams = new LinkedList<String>();
    int n = word.length();
    if (n == 0) {
      anagrams.add(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        //Add the old prefix the new letter
        String newPrefix = prefix + word.charAt(i);
        //Skip the current letter for the next word
        String newWord = word.substring(0, i) + word.substring(i + 1, n);
        anagrams.addAll(getAnagramsInner(newPrefix, newWord));
      }
    }
    return anagrams;
  }
}
