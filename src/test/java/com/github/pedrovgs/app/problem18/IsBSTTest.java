package com.github.pedrovgs.app.problem18;

import com.github.pedrovgs.app.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IsBSTTest {

  private IsBST isBST;

  @Before public void setUp() {
    isBST = new IsBST();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullBinaryTreesRecursive() {
    isBST.checkRecursive(null);
  }

  @Test public void shouldReturnTrueIfTheTreeContainsJustOneNodeRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    assertTrue(isBST.checkRecursive(root));
  }

  @Test public void shouldReturnFalseIfLeftNodesAreGraterThanRightNodesRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    root.setLeft(n2);
    root.setRight(n1);

    assertFalse(isBST.checkRecursive(root));
  }

  @Test public void shouldReturnTrueIfBinaryTreeIsBSTRecursive() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    root.setRight(n2);
    root.setLeft(n1);

    assertTrue(isBST.checkRecursive(root));
  }
}
