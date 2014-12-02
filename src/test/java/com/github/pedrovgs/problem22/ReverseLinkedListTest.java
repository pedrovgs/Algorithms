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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ReverseLinkedListTest {

  private ReverseLinkedList reverseLinkedList;

  @Before public void setUp() {
    reverseLinkedList = new ReverseLinkedList();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullElements() {
    reverseLinkedList.reverse(null);
  }

  @Test public void shouldAcceptLinkedListWithJustOneElement() {
    ListNode<Integer> head = new ListNode<Integer>(1);

    assertEquals(head, reverseLinkedList.reverse(head));
  }

  @Test public void shouldReverseLinkedList() {
    ListNode<Integer> head = new ListNode<Integer>(1);
    ListNode<Integer> n2 = new ListNode<Integer>(2);
    ListNode<Integer> n3 = new ListNode<Integer>(3);
    ListNode<Integer> n4 = new ListNode<Integer>(4);
    head.setNext(n2);
    n2.setNext(n3);

    ListNode reversedList = reverseLinkedList.reverse(head);
    
    assertEquals(n4, reversedList);
  }
}
