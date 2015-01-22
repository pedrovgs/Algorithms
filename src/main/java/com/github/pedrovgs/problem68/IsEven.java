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
package com.github.pedrovgs.problem68;

/**
 * Given a positive int passed as parameter, can you write a method to return true if the number is
 * even or false if the number is odd? The only constraint you have is: you can't use this
 * operator: %.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IsEven {

  /**
   * Easy algorithm based on "and" binary operator and the simplest mask you are going to see, the
   * number 1. In this method we are going to apply one mask with just one one inside and if the
   * result is different of 1 we will return true. This algorithm is possible because every binary
   * number with one one in the position zero is going to be odd. Review how to calculate an
   * integer
   * from a binary number if you don't understand how it works.
   */
  public boolean check(int n) {
    return (n & 1) != 1;
  }
}
