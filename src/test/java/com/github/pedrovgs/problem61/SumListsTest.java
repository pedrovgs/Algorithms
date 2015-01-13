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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SumListsTest {

  private SumLists sumLists;

  @Before public void setUp() {
    sumLists = new SumLists();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullListAsFirstParameterReverse() {
    sumLists.sumReverse(null, new ListNode<Integer>(0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullListAsSecondParameterReverse() {
    sumLists.sumReverse(new ListNode<Integer>(0), null);
  }

  @Test public void shouldSumNumbersWithJustOneDigitReverse() {
    ListNode<Integer> n1 = createList(new int[] { 3 });
    ListNode<Integer> n2 = createList(new int[] { 8 });

    int result = sumLists.sumReverse(n1, n2);

    assertEquals(11, result);
  }

  @Test public void shouldSumNumbersWithMoreThanOneDigitReverse() {
    ListNode<Integer> n1 = createList(new int[] { 5, 5, 1 });
    ListNode<Integer> n2 = createList(new int[] { 4, 1, 3 });

    int result = sumLists.sumReverse(n1, n2);

    assertEquals(469, result);
  }

  @Test public void shouldSumNumbersWithDifferentSizesReverse() {
    ListNode<Integer> n1 = createList(new int[] { 5, 5, 1 });
    ListNode<Integer> n2 = createList(new int[] { 5 });

    int result = sumLists.sumReverse(n1, n2);

    assertEquals(160, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullListAsFirstParameter() {
    sumLists.sum(null, new ListNode<Integer>(0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullListAsSecondParameter() {
    sumLists.sum(new ListNode<Integer>(0), null);
  }

  @Test public void shouldSumNumbersWithJustOneDigit() {
    ListNode<Integer> n1 = createList(new int[] { 3 });
    ListNode<Integer> n2 = createList(new int[] { 8 });

    int result = sumLists.sum(n1, n2);

    assertEquals(11, result);
  }

  @Test public void shouldSumNumbersWithMoreThanOneDigit() {
    ListNode<Integer> n1 = createList(new int[] { 1, 5, 5 });
    ListNode<Integer> n2 = createList(new int[] { 3, 1, 4 });

    int result = sumLists.sum(n1, n2);

    assertEquals(469, result);
  }

  @Test public void shouldSumNumbersWithDifferentSizes() {
    ListNode<Integer> n1 = createList(new int[] { 1, 5, 5 });
    ListNode<Integer> n2 = createList(new int[] { 5 });

    int result = sumLists.sum(n1, n2);

    assertEquals(160, result);
  }

  private ListNode<Integer> createList(int[] integers) {
    ListNode<Integer> head = new ListNode<Integer>(integers[0]);
    if (integers.length > 1) {
      ListNode<Integer> prevNode = head;
      for (int i = 1; i < integers.length; i++) {
        ListNode<Integer> currentNode = new ListNode<Integer>(integers[i]);
        prevNode.setNext(currentNode);
        prevNode = currentNode;
      }
    }
    return head;
  }
}
