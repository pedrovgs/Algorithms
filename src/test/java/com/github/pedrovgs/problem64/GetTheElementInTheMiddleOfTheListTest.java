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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class GetTheElementInTheMiddleOfTheListTest {

  private GetTheElementInTheMiddleOfTheList getTheElementInTheMiddleOfTheList;

  @Before public void setUp() {
    getTheElementInTheMiddleOfTheList = new GetTheElementInTheMiddleOfTheList();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullListInstances() {
    getTheElementInTheMiddleOfTheList.get(null);
  }

  @Test public void shouldReturnTheElementInTheMiddleOfAListWithAnEvenNumberOfElements() {
    ListNode<Integer> list = createList(new int[] { 1, 2, 3 });

    ListNode<Integer> middleElement = getTheElementInTheMiddleOfTheList.get(list);

    assertEquals(Integer.valueOf(2), middleElement.getData());
  }

  @Test public void shouldReturnTheElementInTheMiddleOfTheListWithAnOddNumberOfElements() {
    ListNode<Integer> list = createList(new int[] { 1, 2, 3, 4 });

    ListNode<Integer> middleElement = getTheElementInTheMiddleOfTheList.get(list);

    assertEquals(Integer.valueOf(2), middleElement.getData());
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullListInstances2() {
    getTheElementInTheMiddleOfTheList.get2(null);
  }

  @Test public void shouldReturnTheElementInTheMiddleOfAListWithAnEvenNumberOfElements2() {
    ListNode<Integer> list = createList(new int[] { 1, 2, 3 });

    ListNode<Integer> middleElement = getTheElementInTheMiddleOfTheList.get2(list);

    assertEquals(Integer.valueOf(2), middleElement.getData());
  }

  @Test public void shouldReturnTheElementInTheMiddleOfTheListWithAnOddNumberOfElements2() {
    ListNode<Integer> list = createList(new int[] { 1, 2, 3, 4 });

    ListNode<Integer> middleElement = getTheElementInTheMiddleOfTheList.get2(list);

    assertEquals(Integer.valueOf(2), middleElement.getData());
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
