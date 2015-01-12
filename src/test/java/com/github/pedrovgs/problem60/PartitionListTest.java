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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PartitionListTest {

  private PartitionList partitionList;

  @Before public void setUp() {
    partitionList = new PartitionList();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullLists() {
    partitionList.split(null, 1);
  }

  @Test public void shouldNotSplitListIfXIsMinorThanEveryNode() {
    ListNode<Integer> list = createList(new int[] { 1, 2, 3 });

    ListNode<Integer> result = partitionList.split(list, 0);

    assertListContainsElements(new Integer[] { 3, 2, 1 }, result);
  }

  @Test public void shouldNotSplitListIfXIsGreaterThanEveryNode() {
    ListNode<Integer> list = createList(new int[] { 1, 2, 3 });

    ListNode<Integer> result = partitionList.split(list, 4);

    assertListContainsElements(new Integer[] { 3, 2, 1 }, result);
  }

  @Test public void shouldSplitListUsingX() {
    ListNode<Integer> list = createList(new int[] { 3, 1, 2 });

    ListNode<Integer> result = partitionList.split(list, 2);

    assertListContainsElements(new Integer[] { 1, 2, 3 }, result);
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

  private void assertListContainsElements(Integer[] integers, ListNode<Integer> head) {
    int arrayLength = integers.length;
    ListNode<Integer> currentNode = head;

    int i = 0;
    while (i < arrayLength) {
      assertEquals(integers[i], currentNode.getData());
      currentNode = currentNode.getNext();
      i++;
    }
    assertNull(currentNode);
  }
}
