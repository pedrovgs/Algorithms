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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class DeleteListNodeTest {

  private DeleteListNode deleteNode;

  @Before public void setUp() {
    deleteNode = new DeleteListNode();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullNodes() {
    deleteNode.delete(null);
  }

  @Test public void shouldNotModifyNodeIfListContainsJustThatNode() {
    ListNode<Integer> head = new ListNode<Integer>(1);

    deleteNode.delete(head);

    assertEquals(head, head);
  }

  @Test public void shouldRemoveListNode() {
    ListNode<Integer> head = new ListNode<Integer>(0);
    ListNode<Integer> n1 = new ListNode<Integer>(1);
    ListNode<Integer> n2 = new ListNode<Integer>(2);
    head.setNext(n1);
    n1.setNext(n2);

    deleteNode.delete(n1);

    assertListContainsElements(new Integer[] { 0, 2 }, head);
  }

  @Test public void shouldRemoveHead() {
    ListNode<Integer> head = new ListNode<Integer>(0);
    ListNode<Integer> n1 = new ListNode<Integer>(1);
    ListNode<Integer> n2 = new ListNode<Integer>(2);
    head.setNext(n1);
    n1.setNext(n2);

    deleteNode.delete(head);

    assertListContainsElements(new Integer[] { 1, 2 }, n1);
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
