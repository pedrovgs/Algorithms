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
package com.github.pedrovgs.problem60;

import com.github.pedrovgs.linkedlist.ListNode;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before after nodes greater than or equal to x.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PartitionList {

  /**
   * Iterative algorithm to solve this problem. Using two pointer to the element before the value
   * and after the value we are going to create two list and merge it at the end of this algorithm.
   * The complexity order is equals to O(N) in time terms and O(1) in space terms because we are
   * not
   * using any auxiliary data structure to solve this problem.
   */
  public ListNode<Integer> split(ListNode<Integer> list, int x) {
    validateInput(list);

    ListNode<Integer> before = null;
    ListNode<Integer> after = null;

    while (list != null) {
      ListNode<Integer> next = list.getNext();
      if (list.getData() < x) {
        list.setNext(before);
        before = list;
      } else {
        list.setNext(after);
        after = list;
      }
      list = next;
    }

    if (before == null) {
      return after;
    }

    ListNode<Integer> result = mergeLists(before, after);

    return result;
  }

  private ListNode<Integer> mergeLists(ListNode<Integer> before, ListNode<Integer> after) {
    ListNode<Integer> result = before;
    while (before.getNext() != null) {
      before = before.getNext();
    }
    before.setNext(after);
    return result;
  }

  private void validateInput(ListNode<Integer> list) {
    if (list == null) throw new IllegalArgumentException("You can't pass a null list as argument.");
  }
}
