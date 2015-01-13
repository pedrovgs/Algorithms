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
package com.github.pedrovgs.problem61;

import com.github.pedrovgs.linkedlist.ListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.The
 * digit are stored in reverse order,such that the 1's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 *
 * Suppose the digits are stored in forward order. Repeat the above problem.
 *
 * Negative numbers are not allowed.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SumLists {

  /**
   * Iterative solution to this problem. The complexity order of this algorithm in time terms is
   * O(N) where N is the size of the largest list. In space terms, the complexity order of this
   * algorithm is O(1) because we are not using any additional data structure.
   *
   * This solution could be faster if we iterate over n1 and n2 at the same time just taking care
   * about null pointer exceptions, but the readability could be worst and the complexity order in
   * time terms is the same.
   */
  public int sumReverse(ListNode<Integer> n1, ListNode<Integer> n2) {
    validateInput(n1, n2);

    int n1Value = calculateReverseNumber(n1);
    int n2Value = calculateReverseNumber(n2);
    return n1Value + n2Value;
  }

  private int calculateReverseNumber(ListNode<Integer> list) {
    int value = 0;
    int i = 0;
    while (list != null) {
      value += list.getData() * Math.pow(10, i);
      list = list.getNext();
      i++;
    }
    return value;
  }

  /**
   * Iterative solution to solve this problem. The complexity order is the same than in the
   * previous algorithm in time and space terms, but the execution time is bigger here because we
   * need to know the list size to be able to transform the list into an integer.
   */
  public int sum(ListNode<Integer> n1, ListNode<Integer> n2) {
    validateInput(n1, n2);

    int n1Value = calculateNumber(n1);
    int n2Value = calculateNumber(n2);
    return n1Value + n2Value;
  }

  private int calculateNumber(ListNode<Integer> list) {
    int value = 0;
    int digits = getListSize(list) - 1;
    while (list != null) {
      value += list.getData() * Math.pow(10, digits);
      list = list.getNext();
      digits--;
    }
    return value;
  }

  private int getListSize(ListNode<Integer> list) {
    int size = 0;
    while (list != null) {
      list = list.getNext();
      size++;
    }
    return size;
  }

  private void validateInput(ListNode<Integer> n1, ListNode<Integer> n2) {
    if (n1 == null || n2 == null) {
      throw new IllegalArgumentException("You can't pass a null list as parameter.");
    }
  }
}
