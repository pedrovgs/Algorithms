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
package com.github.pedrovgs.problem64;

import com.github.pedrovgs.linkedlist.ListNode;

/**
 * Given a singly linked list, can you write a method to return the element in the middle of the
 * list?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class GetTheElementInTheMiddleOfTheList {

  /**
   * Iterative solution to this problem. The complexity order of this algorithm in time terms is
   * equals to O(N) where N is the number of elements in the list. In space terms, the complexity
   * order is O(1) because we are not using any auxiliary data structure to solve this problem.
   * This algorithm is based on know the size of the list, but this part of the algorithm is a
   * problem for the execution time.
   */
  public ListNode<Integer> get(ListNode<Integer> list) {
    validateInput(list);

    int size = getListSize(list);
    int middleElementPosition = size % 2 != 0 ? size / 2 : (size / 2) - 1;
    ListNode middleElement = list;
    for (int i = 0; i < middleElementPosition; i++) {
      middleElement = middleElement.getNext();
    }
    return middleElement;
  }

  private int getListSize(ListNode<Integer> list) {
    int size = 0;
    ListNode currentNode = list;
    while (currentNode != null) {
      size++;
      currentNode = currentNode.getNext();
    }
    return size;
  }

  /**
   * Iterative solution to this problem. The complexity order of this algorithm in time and space
   * terms is equivalent to the previous algorithm but the execution time is lower in this version.
   * The key of this algorithm is based on use two pointers, going going two times faster trough
   * the
   * list during the iteration.
   */
  public ListNode<Integer> get2(ListNode<Integer> list) {
    validateInput(list);

    ListNode<Integer> currentNode = list;
    ListNode<Integer> fastNode = list.getNext();
    while (fastNode != null && fastNode.getNext() != null) {
      currentNode = currentNode.getNext();
      fastNode = fastNode.getNext().getNext();
    }
    return currentNode;
  }

  private void validateInput(ListNode list) {
    if (list == null) {
      throw new IllegalArgumentException("You can't pass a null instance of list");
    }
  }
}
