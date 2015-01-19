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
package com.github.pedrovgs.binarytree;

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

  public boolean hasLeft() {
    return left != null;
  }

  public boolean hasRight() {
    return right != null;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BinaryNode)) return false;

    BinaryNode that = (BinaryNode) o;

    if (!data.equals(that.data)) return false;
    if (left != null ? !left.equals(that.left) : that.left != null) return false;
    if (right != null ? !right.equals(that.right) : that.right != null) return false;

    return true;
  }

  @Override public int hashCode() {
    int result = data.hashCode();
    result = 31 * result + (left != null ? left.hashCode() : 0);
    result = 31 * result + (right != null ? right.hashCode() : 0);
    return result;
  }

  @Override public String toString() {
    return "BinaryNode{" + "data=" + data + '}';
  }
}
