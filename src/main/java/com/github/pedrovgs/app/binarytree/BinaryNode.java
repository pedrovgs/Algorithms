package com.github.pedrovgs.app.binarytree;

/**
 * Main class for binary trees data structure. A binary tree is a tree data structure in which each
 * node has at most two children, which are referred to as the left child and the right child. A
 * recursive definition using just set theory notions is that a (non-empty) binary tree is a triple
 * (L, S, R), where L and R are binary trees or the empty set and S is a singleton set. Some
 * authors allow the binary tree to be the empty set as well.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryNode<T> {

  private final T data;
  private BinaryNode<T> left;
  private BinaryNode<T> right;

  public BinaryNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public BinaryNode<T> getLeft() {
    return left;
  }

  public void setLeft(BinaryNode<T> left) {
    this.left = left;
  }

  public BinaryNode<T> getRight() {
    return right;
  }

  public void setRight(BinaryNode<T> right) {
    this.right = right;
  }
}
