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
package com.github.pedrovgs.problem62;

import com.github.pedrovgs.linkedlist.ListNode;
import com.github.pedrovgs.problem22.ReverseLinkedList;

/**
 * Implement a function to check if a linked list is a palindrome,
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PalindromeList {

  private final ReverseLinkedList reverseLinkedList;

  public PalindromeList() {
    this.reverseLinkedList = new ReverseLinkedList();
  }

  /**
   * Iterative algorithm to solve this problem. If a List is a palindrome the reverse list has to
   * be equals to the original list. This is the base of this algorithm. The complexity order is
   * the same than reverse list algorithm - O(N) in time terms - because
   * this is the most expensive operation. In space terms, the complexity order of this algorithm
   * is
   * O(N).
   */
  public boolean checkReversing(ListNode list) {
    validateInput(list);

    ListNode<Integer> reversedList = reverseLinkedList.reverseIterative(list);

    boolean isPalindrome = true;
    while (list != null) {
      isPalindrome = list.equals(reversedList);
      if (!isPalindrome) {
        break;
      }
      reversedList = reversedList.getNext();
      list = list.getNext();
    }
    return isPalindrome;
  }

  private void validateInput(ListNode<Integer> list) {
    if (list == null) {
      throw new IllegalArgumentException("You can't pass a null list as parameter.");
    }
  }
}
