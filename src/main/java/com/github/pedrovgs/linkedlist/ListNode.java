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
package com.github.pedrovgs.linkedlist;

/**
 * Main class for linked list data structure. A linked list is a data structure consisting of a
 * group of nodes which together represent a sequence. Under the simplest form, each node is
 * composed of a data and a reference (in other words, a link) to the next node in the sequence;
 * more complex variants add additional links. This structure allows for efficient insertion or
 * removal of elements from any position in the sequence.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ListNode<T> {

  private T data;
  private ListNode<T> next;

  public ListNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public ListNode<T> getNext() {
    return next;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ListNode)) return false;

    ListNode listNode = (ListNode) o;

    if (!data.equals(listNode.data)) return false;

    return true;
  }

  @Override public int hashCode() {
    return data.hashCode();
  }

  @Override public String toString() {
    return "ListNode{" + "data=" + data + ", next=" + next + '}';
  }
}
