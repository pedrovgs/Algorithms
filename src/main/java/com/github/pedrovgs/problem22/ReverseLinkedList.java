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
package com.github.pedrovgs.problem22;

import com.github.pedrovgs.linkedlist.ListNode;

/**
 * Given a singly linked list, can you write a method to return the reversed list?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReverseLinkedList {

  /**
   * Iterative solution for this problem. The complexity order of this algorithm in time terms is
   * O(N) where N is the number of elements in the list. The complexity order in this algorithm in
   * space terms is O(1) because we only use two additional pointers and we don't allocate memory.
   */
  public ListNode reverseIterative(ListNode list) {
    validateInput(list);

    if (list.getNext() == null) {
      return list;
    }

    ListNode head = null;
    ListNode current = list;
    while (current != null) {
      ListNode save = current;
      current = current.getNext();
      save.setNext(head);
      head = save;
    }
    return head;
  }

  /**
   * Recursive solution to this problem. The complexity order of this algorithm in time terms is
   * O(N) where N is the number of elements in the list. The complexity order in this algorithm in
   * space terms is O(1) because we only use two additional pointers and we don't allocate memory.
   */
  public ListNode<Integer> reverseRecursive(ListNode list) {
    validateInput(list);
    return reverseRecursiveInner(list);
  }

  private ListNode<Integer> reverseRecursiveInner(ListNode head) {
    if (head == null || head.getNext() == null) {
      return head;
    } else {
      ListNode reversedList = reverseRecursiveInner(head.getNext());
      head.getNext().setNext(head);
      head.setNext(null);
      return reversedList;
    }
  }

  private void validateInput(ListNode list) {
    if (list == null) {
      throw new IllegalArgumentException("You can't pass a null list as parameter.");
    }
  }
}
