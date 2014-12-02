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
package com.github.pedrovgs.problem21;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class LowestCommonAncestorTest {

  private LowestCommonAncestor lca;

  @Before public void setUp() {
    lca = new LowestCommonAncestor();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullElementsRecursive() {
    lca.getRecursive(null, null, null);
  }

  @Test public void shouldFindLCAWhenIsAFatherOfBothNodesRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
    BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
    BinaryNode<Integer> n6 = new BinaryNode<Integer>(6);
    root.setLeft(n2);
    root.setRight(n3);
    n2.setLeft(n4);
    n2.setRight(n5);
    n4.setLeft(n6);

    BinaryNode result = lca.getRecursive(root, n5, n6);

    assertEquals(n2, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullElementsIterative() {
    lca.getIterative(null, null, null);
  }

  @Test public void shouldFindLCAWhenIsAFatherOfBothNodesIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
    BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
    BinaryNode<Integer> n6 = new BinaryNode<Integer>(6);
    root.setLeft(n2);
    root.setRight(n3);
    n2.setLeft(n4);
    n2.setRight(n5);
    n4.setLeft(n6);

    BinaryNode result = lca.getIterative(root, n5, n6);

    assertEquals(n2, result);
  }
}

