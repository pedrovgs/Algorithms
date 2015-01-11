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
package com.github.pedrovgs.problem59;

import com.github.pedrovgs.linkedlist.ListNode;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access
 * to that node.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DeleteListNode {

  /**
   * Iterative algorithm to solve this problem. We don't have access to the head of the list, and
   * the only thing we can do is to move the data from the next node to the current one, the data
   * and the pointer to the next node. This approach doesn't work with the last element in the
   * list, but there is no another valid approach to solve this algorithm without access to the
   * head of the list.
   */
  public void delete(ListNode node) {
    validateInputData(node);

    if (node.getNext() == null) {
      return;
    }
    ListNode next = node.getNext();
    node.setData(next.getData());
    node.setNext(next.getNext());
  }

  private void validateInputData(ListNode node) {
    if (node == null) {
      throw new IllegalArgumentException(
          "You can't pass a null instance of ListNode as parameter.");
    }
  }
}
