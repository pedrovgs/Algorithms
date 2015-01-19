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
package com.github.pedrovgs.problem66;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class TreeToListByLevelTest {

  private TreeToListByLevel toList;

  @Before public void setUp() {
    toList = new TreeToListByLevel();
  }

  @Test public void shouldReturnEmptyListIfTreeIsNull() {
    List<BinaryNode> result = toList.transform(null);

    assertTrue(result.isEmpty());
  }

  @Test public void shouldReturnListWithJustOneNodeIfTreeContainsJustOneNode() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    List<BinaryNode> result = toList.transform(root);

    assertEquals(1, result.size());
    assertTrue(result.contains(root));
  }

  @Test public void shouldReturnListWithTreeElementsByLevel() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    root.setLeft(n1);
    root.setRight(n2);
    n1.setLeft(n3);

    List<BinaryNode> result = toList.transform(root);

    assertEquals(4, result.size());
    assertEquals(root, result.get(0));
    assertEquals(n1, result.get(1));
    assertEquals(n2, result.get(2));
    assertEquals(n3, result.get(3));
  }
}
