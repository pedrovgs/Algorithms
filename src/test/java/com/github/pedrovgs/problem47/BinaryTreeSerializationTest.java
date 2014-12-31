package com.github.pedrovgs.problem47;

import com.github.pedrovgs.binarytree.BinaryNode;
import com.github.pedrovgs.problem46.BinaryTreeSerialization;
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

    String serializedTree = binaryTreeSerialization.serializeInner(root);
    BinaryNode<Integer> deserializedTree = binaryTreeSerialization.deserialize(serializedTree);

    assertEquals(root, deserializedTree);
  }
}
