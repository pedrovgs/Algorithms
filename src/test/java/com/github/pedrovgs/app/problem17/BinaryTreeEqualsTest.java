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
package com.github.pedrovgs.app.problem17;

import com.github.pedrovgs.app.binarytree.BinaryNode;
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

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptTwoNullTrees() {
    binaryTreeEquals.areEquals(null, null);
  }

  @Test public void shouldReturnFalseIfOneIsNull() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    assertFalse(binaryTreeEquals.areEquals(root, null));
  }

  @Test public void shouldReturnTrueIfBothElementsAreEqualsEvenIfJustContainsOneElement() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);

    assertTrue(binaryTreeEquals.areEquals(root, root1));
  }

  @Test public void shouldReturnFalseIfTreesAreNotEquals() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    root.setLeft(n1);
    BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);

    assertFalse(binaryTreeEquals.areEquals(root, root1));
  }

  @Test public void shouldReturnTrueIfTreesAreEquals() {
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

    assertFalse(binaryTreeEquals.areEquals(root, root1));
  }
}
