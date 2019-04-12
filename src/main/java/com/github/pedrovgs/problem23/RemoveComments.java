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
package com.github.pedrovgs.problem23;

/**
 * Given a file we are going to read it line by line, can you write a method to remove block
 * comments marked with '/*' and '*\'. Simulate the input file if needed.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RemoveComments {

  private static final char ASTERISK = '*';
  private static final char SLASH = '/';
  private static final char ANY_CHAR = 'c';

  /**
   * Iterative solution to this problem. This algorithm has a complexity order in space terms
   * equals to O(1) because we are not using any additional data structure to store temporal data.
   * In time terms this algorithm has a complexity order equals to O(N) because we are going to
   * check every single character inside the file.
   *
   * This algorithm could be easier to read if we replace the char checks for indexOf methods. But
   * indexOf usage has a complexity order equals to O(N) and the result could be really slow.
   */
  public String remove(FakeFile file) {
    if (file == null) {
      throw new IllegalArgumentException("You can't pass a null file as argument.");
    }

    StringBuilder result = new StringBuilder();
    boolean openComment = false;
    String line = file.getLine();
    while (line != null) {
      char previous = ANY_CHAR;
      int openIndex = -1;

      char[] arr = line.toCharArray();
      for (int i = 0; i < arr.length; i++) {
        char c = arr[i];
        if (openComment) {
          if (c == SLASH && previous == ASTERISK && openIndex < (i - 2)) {
            openComment = false;
          }
        } else {
          if (c == ASTERISK && previous == SLASH) {
            openIndex = i - 1;
            openComment = true;
            result.deleteCharAt(result.length() - 1);
          } else {
            result.append(c);
          }
        }
        previous = c;
      }
      line = file.getLine();
    }
    return result.toString();
  }
}
