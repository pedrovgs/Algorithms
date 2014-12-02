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
package com.github.pedrovgs.problem18;

import com.github.pedrovgs.binarytree.BinaryNode;
import com.github.pedrovgs.problem15.BinaryTreeInOrder;
import java.util.List;

/**
 * Given a binary tree passed as argument, can you write a method to return true if the binary tree
 * is a Binary Search Tree?
 *
 * A Binary Search Tree (BST), sometimes also called an ordered or sorted binary tree, is a
 * node-based binary tree data structure where each node has a comparable key (and an associated
 * value) and satisfies the restriction that the key in any node is larger than the keys in all
 * nodes in that node's left sub-tree and smaller than the keys in all nodes in that node's right
 * sub-tree. Each node has no more than two child nodes. Each child must either be a leaf node or
 * the root of another binary search tree. The left sub-tree contains only nodes with keys less
 * than
 * the parent node; the right sub-tree contains only nodes with keys greater than the parent node.
 * BSTs are also dynamic data structures, and the size of a BST is only limited by the amount of
 * free memory in the operating system. The main advantage of binary search trees is that it
 * remains
 * ordered, which provides quicker search times than many other data structures.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IsBST {

  private BinaryTreeInOrder binaryTreeInOrder = new BinaryTreeInOrder();

  /**
   * Recursive implementation to solve this problem. This algorithm has O(N) as complexity order in
   * time terms and O(1) in space terms.
   */
  public boolean checkRecursive(BinaryNode<Integer> root) {
    validateInput(root);
    return checkRecursiveInner(root);
  }

  private boolean checkRecursiveInner(BinaryNode<Integer> root) {
    if (root == null) {
      return true;
    } else {
      return (root.getLeft() == null || root.getData() >= root.getLeft().getData())
          && (root.getRight() == null || root.getData() <= root.getRight().getData())
          && checkRecursiveInner(root.getLeft())
          && checkRecursiveInner(root.getRight());
    }
  }

  /**
   * Iterative solution to this problem. This algorithm is based on BST properties. If one tree is
   * BST an in order tour through the tree have to return an already sorted list of elements. The
   * complexity of this algorithm is O(N) + O(N) = O(N) in time terms and O(N) in space terms. Is
   * slower than the previous solution but it's an interesting solution based on a already resolved
   * problem, BST in order = sorted list.
   */
  public boolean checkIterative(BinaryNode<Integer> root) {
    validateInput(root);
    List<BinaryNode<Integer>> nodesInOrder = binaryTreeInOrder.getRecursive(root);
    return isListOrdered(nodesInOrder);
  }

  private boolean isListOrdered(List<BinaryNode<Integer>> nodes) {
    if (nodes.size() == 1) {
      return true;
    }
    for (int i = 0; i < nodes.size() - 1; i++) {
      if (nodes.get(i).getData() > nodes.get(i + 1).getData()) {
        return false;
      }
    }
    return true;
  }

  private void validateInput(BinaryNode<Integer> root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't pass null BinaryNode elements as parameter.");
    }
  }
}
