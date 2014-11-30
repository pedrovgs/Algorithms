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
package com.github.pedrovgs.problem17;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeEqualsTest {

  private BinaryTreeEquals binaryTreeEquals;

  @Before public void setUp() {
    this.binaryTreeEquals = new BinaryTreeEquals();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptTwoNullTreesRecursive() {
    binaryTreeEquals.areEqualsRecursive(null, null);
  }

  @Test public void shouldReturnFalseIfOneIsNullRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    assertFalse(binaryTreeEquals.areEqualsRecursive(root, null));
  }

  @Test public void shouldReturnTrueIfBothElementsAreEqualsEvenIfJustContainsOneElementRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);

    assertTrue(binaryTreeEquals.areEqualsRecursive(root, root1));
  }

  @Test public void shouldReturnFalseIfTreesAreNotEqualsRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    root.setLeft(n1);
    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);

    assertFalse(binaryTreeEquals.areEqualsRecursive(root, root1));
  }

  @Test public void shouldReturnTrueIfTreesAreEqualsRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    root.setLeft(n1);
    root.setRight(n2);
    n1.setLeft(n3);

    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n11 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n21 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n31 = new BinaryNode<Integer>(3);
    root.setLeft(n11);
    root.setRight(n21);
    n1.setLeft(n31);

    assertFalse(binaryTreeEquals.areEqualsRecursive(root, root1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptTwoNullTreesIterative() {
    binaryTreeEquals.areEqualsIterative(null, null);
  }

  @Test public void shouldReturnFalseIfOneIsNullIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    assertFalse(binaryTreeEquals.areEqualsIterative(root, null));
  }

  @Test public void shouldReturnTrueIfBothElementsAreEqualsEvenIfJustContainsOneElementIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);

    assertTrue(binaryTreeEquals.areEqualsIterative(root, root1));
  }

  @Test public void shouldReturnFalseIfTreesAreNotEqualsIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    root.setLeft(n1);
    root.setRight(n2);
    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n11 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n21 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n31 = new BinaryNode<Integer>(3);
    root.setLeft(n11);
    root.setRight(n21);
    n21.setRight(n31);

    assertFalse(binaryTreeEquals.areEqualsIterative(root, root1));
  }

  @Test public void shouldReturnTrueIfTreesAreEqualsIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    root.setLeft(n1);
    root.setRight(n2);
    n1.setLeft(n3);

    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n11 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n21 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n31 = new BinaryNode<Integer>(3);
    root.setLeft(n11);
    root.setRight(n21);
    n1.setLeft(n31);

    assertFalse(binaryTreeEquals.areEqualsIterative(root, root1));
  }
}
