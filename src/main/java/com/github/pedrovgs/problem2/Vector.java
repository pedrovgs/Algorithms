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
package com.github.pedrovgs.problem2;

/**
 * Class created to represent a Vector of integers. This class uses an array as main data structure
 * because the number of elements inside a vector can't change and we can provide constant
 * complexity order O(1) to access random elements inside the array.
 *
 * For simplicity, we are going to assume that the only type of elements we are going to use is
 * int. We could change this implementation to use generics and accept different types if needed.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Vector {

  private final int[] elements;

  public Vector(int... elements) {
    if (elements == null) {
      elements = new int[0];
    }
    this.elements = elements;
  }

  public int getAt(int index) {
    return elements[index];
  }

  public int size() {
    return elements.length;
  }
}
