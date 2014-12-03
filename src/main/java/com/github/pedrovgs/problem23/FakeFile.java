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
 * Class created to simulate a File object for problem 23.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class FakeFile {

  private final String[] lines;
  private int index;

  FakeFile(String... lines) {
    this.lines = lines != null ? lines : new String[0];
  }

  String getLine() {
    return index <= lines.length - 1 ? lines[index++] : null;
  }
}
