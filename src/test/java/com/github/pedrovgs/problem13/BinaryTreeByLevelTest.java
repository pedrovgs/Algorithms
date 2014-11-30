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
package com.github.pedrovgs.problem13;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeByLevelTest {

  private BinaryTreeByLevel binaryTreeByLevel;

  @Before public void setUp() {
    binaryTreeByLevel = new BinaryTreeByLevel();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullBinaryNodesUsingQueue() {
    binaryTreeByLevel.getUsingQueue(null);
  }

  @Test public void shouldReturnTheSameNodeInTheListIfTheTreeJustContainsOneElementUsingQueue() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    List<BinaryNode> result = binaryTreeByLevel.getUsingQueue(root);

    List<BinaryNode<Integer>> expectedList = Arrays.asList(root);
    assertEquals(expectedList, result);
  }

  @Test public void shouldWorkWithALittleBinaryTreeUsingQueue() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    root.setLeft(n1);
    root.setRight(n2);

    List<BinaryNode> result = binaryTreeByLevel.getUsingQueue(root);

    List<BinaryNode<Integer>> expectedList = Arrays.asList(root, n1, n2);
    assertEquals(expectedList, result);
  }

  @Test public void shouldWorkWithABiggerBinaryTreeUsingQueue() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
    BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
    root.setLeft(n1);
    root.setRight(n2);
    n1.setLeft(n3);
    n1.setRight(n4);
    n2.setLeft(n5);

    List<BinaryNode> result = binaryTreeByLevel.getUsingQueue(root);

    List<BinaryNode<Integer>> expectedList = Arrays.asList(root, n1, n2, n3, n4, n5);
    assertEquals(expectedList, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullBinaryNodesWithoutExtraDataStructure() {
    binaryTreeByLevel.getWithoutAdditionalDataStructures(null);
  }

  @Test
  public void shouldReturnTheSameNodeInTheListIfTheTreeJustContainsOneElementWithoutExtraDataStructure() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    List<BinaryNode> result = binaryTreeByLevel.getWithoutAdditionalDataStructures(root);

    List<BinaryNode<Integer>> expectedList = Arrays.asList(root);
    assertEquals(expectedList, result);
  }

  @Test public void shouldWorkWithALittleBinaryTreeWithoutExtraDataStructure() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    root.setLeft(n1);
    root.setRight(n2);

    List<BinaryNode> result = binaryTreeByLevel.getWithoutAdditionalDataStructures(root);

    List<BinaryNode<Integer>> expectedList = Arrays.asList(root, n1, n2);
    assertEquals(expectedList, result);
  }

  @Test public void shouldWorkWithABiggerBinaryTreeWithoutExtraDataStructure() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
    BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
    root.setLeft(n1);
    root.setRight(n2);
    n1.setLeft(n3);
    n1.setRight(n4);
    n2.setLeft(n5);

    List<BinaryNode> result = binaryTreeByLevel.getWithoutAdditionalDataStructures(root);

    List<BinaryNode<Integer>> expectedList = Arrays.asList(root, n1, n2, n3, n4, n5);
    assertEquals(expectedList, result);
  }
}
