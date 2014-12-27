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
package com.github.pedrovgs.problem43;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a set of integers, can you write a method to calculate every possible combination?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CombinationOfIntegers {

  /**
   * Combination of recursive and iterative approach to resolve this problem.
   */
  public Set<Set<Integer>> calculate(Set<Integer> originalSet) {
    validateInputSet(originalSet);

    Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
    //Base class returns the empty set.
    if (originalSet.isEmpty()) {
      sets.add(new HashSet<Integer>());
      return sets;
    }
    //Take the first element in head.
    List<Integer> list = new ArrayList<Integer>(originalSet);
    Integer head = list.get(0);
    //Generate a hash set without the first element
    Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
    //Recursive call to iterate over every combination generated with the rest list.
    for (Set<Integer> set : calculate(rest)) {
      //Add every element and the head, the old set and the new set.
      Set<Integer> newSet = new HashSet<Integer>();
      newSet.add(head);
      newSet.addAll(set);
      sets.add(newSet);
      sets.add(set);
    }
    return sets;
  }

  private void validateInputSet(Set<Integer> inputSet) {
    if (inputSet == null) {
      throw new IllegalArgumentException("You can't pass a null set as input.");
    }
  }
}
