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
package com.github.pedrovgs.problem37;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an absolute path and two relative paths to a directory, can you write a method to
 * calculate
 * the final path?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PathCalculator {

  public static final String DIR_SEPARATOR = "/";

  /**
   * Iterative algorithm to solve this problem. The complexity order of this algorithm is O(N+M+Ñ)
   * where N,M and Ñ are the length of every path. We are going to transform string path to arrays
   * and evaluate every one in a different way adding and subtracting elements from a list.
   */
  public String calculate(String absolute, String r1, String r2) {
    if (absolute == null || r1 == null || r2 == null) {
      throw new IllegalArgumentException("You can't pass null strings as input.");
    }

    String[] absolutePath = absolute.split(DIR_SEPARATOR);
    String[] r1Path = r1.split(DIR_SEPARATOR);
    String[] r2Path = r2.split(DIR_SEPARATOR);
    String[] result = calculatePath(absolutePath, r1Path, r2Path);

    StringBuilder stringBuilder = new StringBuilder(DIR_SEPARATOR);
    for (String dir : result) {
      stringBuilder.append(dir);
      stringBuilder.append("/");
    }
    return stringBuilder.toString();
  }

  private static String[] calculatePath(String[]... paths) {
    List<String> finalPath = new LinkedList<String>();
    for (String[] path : paths) {
      for (String dir : path) {
        if (dir.equals("..")) {
          if (!finalPath.isEmpty()) {
            finalPath.remove(finalPath.size() - 1);
          }
        } else if (!dir.isEmpty()) {
          finalPath.add(dir);
        }
      }
    }
    return finalPath.toArray(new String[finalPath.size()]);
  }
}
