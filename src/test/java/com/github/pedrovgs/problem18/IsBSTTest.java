package com.github.pedrovgs.problem18;

import com.github.pedrovgs.binarytree.BinaryNode;
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
    n1.setLeft(root);
    n1.setRight(n2);

    assertTrue(isBST.checkRecursive(n1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullBinaryTreesIterative() {
    isBST.checkIterative(null);
  }

  @Test public void shouldReturnTrueIfTheTreeContainsJustOneNodeIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);

    assertTrue(isBST.checkIterative(root));
  }

  @Test public void shouldReturnFalseIfLeftNodesAreGraterThanRightNodesIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    root.setLeft(n2);
    root.setRight(n1);

    assertFalse(isBST.checkIterative(root));
  }

  @Test public void shouldReturnTrueIfBinaryTreeIsBSTIterative() {
    BinaryNode<Integer> root = new BinaryNode<Integer>(0);
    BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
    BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
    n1.setLeft(root);
    n1.setRight(n2);

    assertTrue(isBST.checkIterative(n1));
  }
}
