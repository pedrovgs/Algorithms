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

package com.github.pedrovgs.pair;

/**
 * Generic data structure used to contains two elements as a pair.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Pair<A, B> {

  private final A a;
  private final B b;

  public Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pair)) {
      return false;
    }

    Pair pair = (Pair) o;

    if (!a.equals(pair.a)) {
      return false;
    }
    if (!b.equals(pair.b)) {
      return false;
    }

    return true;
  }

  @Override public int hashCode() {
    int result = a.hashCode();
    result = 31 * result + b.hashCode();
    return result;
  }
}
