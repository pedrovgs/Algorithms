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
package com.github.pedrovgs.problem36;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class AvlTreeMedianTest {

  private static final double DELTA = 0.1;

  private AvlTreeMedian avlTreeMedian;

  @Before public void setUp() {
    avlTreeMedian = new AvlTreeMedian();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullTrees() {
    avlTreeMedian.find(null);
  }

  @Test public void shouldReturnRootElementIfTheTreeContainsJustOneElement() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(1);

    double median = avlTreeMedian.find(root);

    assertEquals(1, median, DELTA);
  }

  @Test public void shouldReturnRootElementIfTheTreeContainsTFiveElements() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
    BinaryNode<Integer> n5 = new BinaryNode<Integer>(-1);

    root.setLeft(n1);
    root.setRight(n3);
    n3.setRight(n4);
    n1.setLeft(n5);

    double median = avlTreeMedian.find(root);

    assertEquals(2, median, DELTA);
  }

  @Test public void shouldFindMedianWithAEvenNumberOfElements() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(50);
    BinaryNode<Integer> n17 = new BinaryNode<Integer>(17);
    BinaryNode<Integer> n76 = new BinaryNode<Integer>(76);
    BinaryNode<Integer> n9 = new BinaryNode<Integer>(9);
    BinaryNode<Integer> n14 = new BinaryNode<Integer>(14);
    BinaryNode<Integer> n23 = new BinaryNode<Integer>(23);
    BinaryNode<Integer> n54 = new BinaryNode<Integer>(54);
    BinaryNode<Integer> n72 = new BinaryNode<Integer>(72);
    BinaryNode<Integer> n90 = new BinaryNode<Integer>(90);
    BinaryNode<Integer> n89 = new BinaryNode<Integer>(89);
    BinaryNode<Integer> n91 = new BinaryNode<Integer>(91);
    BinaryNode<Integer> n92 = new BinaryNode<Integer>(93);

    root.setLeft(n17);
    root.setRight(n76);
    n17.setLeft(n9);
    n9.setRight(n14);
    n17.setRight(n23);
    n76.setLeft(n54);
    n54.setRight(n72);
    n76.setRight(n90);
    n90.setLeft(n89);
    n90.setRight(n91);
    n91.setRight(n92);

    double median = avlTreeMedian.find(root);

    assertEquals(63, median, DELTA);
  }

  @Test public void shouldFindMedianWithAnOddNumberOfElements() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(50);
    BinaryNode<Integer> n17 = new BinaryNode<Integer>(17);
    BinaryNode<Integer> n76 = new BinaryNode<Integer>(76);
    BinaryNode<Integer> n9 = new BinaryNode<Integer>(9);
    BinaryNode<Integer> n14 = new BinaryNode<Integer>(14);
    BinaryNode<Integer> n23 = new BinaryNode<Integer>(23);
    BinaryNode<Integer> n54 = new BinaryNode<Integer>(54);
    BinaryNode<Integer> n72 = new BinaryNode<Integer>(72);
    BinaryNode<Integer> n90 = new BinaryNode<Integer>(90);
    BinaryNode<Integer> n89 = new BinaryNode<Integer>(89);
    BinaryNode<Integer> n91 = new BinaryNode<Integer>(91);

    root.setLeft(n17);
    root.setRight(n76);
    n17.setLeft(n9);
    n9.setRight(n14);
    n17.setRight(n23);
    n76.setLeft(n54);
    n54.setRight(n72);
    n76.setRight(n90);
    n90.setLeft(n89);
    n90.setRight(n91);

    double median = avlTreeMedian.find(root);

    assertEquals(54, median, DELTA);
  }
}
