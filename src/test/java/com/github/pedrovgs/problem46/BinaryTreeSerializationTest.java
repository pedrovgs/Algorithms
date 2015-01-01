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
package com.github.pedrovgs.problem46;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeSerializationTest {

  private BinaryTreeSerialization binaryTreeSerialization;

  @Before public void setUp() {
    binaryTreeSerialization = new BinaryTreeSerialization();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullBinaryTreesToSerialize() {
    binaryTreeSerialization.serialize(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullStringsToDeserialize() {
    binaryTreeSerialization.deserialize(null);
  }

  @Test public void shouldSerializeAndDeserializeTreeWithJustOneElement() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    String serializedTree = binaryTreeSerialization.serialize(root);
    BinaryNode<Integer> deserializedTree = binaryTreeSerialization.deserialize(serializedTree);

    assertEquals(root, deserializedTree);
  }

  @Test public void shouldSerializeAndDeserializeTreeWithMoreThanOneElement() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
    root.setLeft(n1);
    root.setRight(n2);
    n2.setLeft(n3);

    String serializedTree = binaryTreeSerialization.serialize(root);
    BinaryNode<Integer> deserializedTree = binaryTreeSerialization.deserialize(serializedTree);

    assertEquals(root, deserializedTree);
  }
}
