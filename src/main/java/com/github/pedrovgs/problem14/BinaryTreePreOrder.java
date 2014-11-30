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
package com.github.pedrovgs.problem14;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, can you write a method to get a List<BinaryNode> using a pre order
 * traversal?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreePreOrder {

  /**
   * Recursive implementation of this binary tree traversal. The complexity order of this
   * algorithms in time terms is O(N) and O(N) in space terms because we are using one additional
   * data structure to return the result.
   */
  public List<BinaryNode> getRecursive(BinaryNode root) {
    validateBinaryNode(root);
    return getInner(root);
  }

  private List<BinaryNode> getInner(BinaryNode root) {
    List<BinaryNode> result = new LinkedList<BinaryNode>();
    if (root != null) {
      result.add(root);
      result.addAll(getInner(root.getLeft()));
      result.addAll(getInner(root.getRight()));
    }
    return result;
  }

  /**
   * Iterative implementation of this binary tree traversal. The complexity order in time terms of
   * this algorithm is O(N) where N is the number of nodes in the tree. In space terms the
   * complexity order of this algorithm is also O(N) where N is the number of nodes we have to
   * store in the auxiliary data structure, the stack.
   */
  public List<BinaryNode> getIterative(BinaryNode root) {
    validateBinaryNode(root);
    List<BinaryNode> result = new LinkedList<BinaryNode>();
    Stack<BinaryNode> stack = new Stack<BinaryNode>();
    stack.push(root);

    while (!stack.isEmpty()) {
      BinaryNode node = stack.pop();
      result.add(node);
      if (node.hasRight()) {
        stack.add(node.getRight());
      }
      if (node.hasLeft()) {
        stack.add(node.getLeft());
      }
    }

    return result;
  }

  private void validateBinaryNode(BinaryNode root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't pass a null BinaryNode.");
    }
  }
}
