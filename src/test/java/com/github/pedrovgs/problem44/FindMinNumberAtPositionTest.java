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
package com.github.pedrovgs.problem44;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FindMinNumberAtPositionTest {

  private FindMinNumberAtPosition findMinNumberAtPosition;

  @Before public void setUp() {
    findMinNumberAtPosition = new FindMinNumberAtPosition();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullBinaryTrees() {
    findMinNumberAtPosition.find(null, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNegativePositionsToSearch() {
    BinaryNode<Integer> tree = new BinaryNode<Integer>(1);
    findMinNumberAtPosition.find(tree, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionIfPositionIsGreaterThanNumberOfElementsInTheTree() {
    BinaryNode<Integer> tree = new BinaryNode<Integer>(1);
    findMinNumberAtPosition.find(tree, 1);
  }

  @Test public void shouldFindMinNumberAtPosition() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(8);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    BinaryNode<Integer> n10 = new BinaryNode<Integer>(10);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n6 = new BinaryNode<Integer>(6);
    BinaryNode<Integer> n14 = new BinaryNode<Integer>(14);
    BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
    BinaryNode<Integer> n7 = new BinaryNode<Integer>(7);
    BinaryNode<Integer> n13 = new BinaryNode<Integer>(13);

    root.setLeft(n3);
    root.setRight(n10);
    n3.setLeft(n1);
    n3.setRight(n6);
    n6.setLeft(n4);
    n6.setRight(n7);
    n10.setRight(n14);
    n14.setLeft(n13);

    int result = findMinNumberAtPosition.find(root, 3);

    assertEquals(4, result);
  }
}
