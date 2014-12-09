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
package com.github.pedrovgs.problem15;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, can you write a method to get a List<BinaryNode> using a in order
 * traversal?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeInOrder {

  /**
   * Recursive implementation of this binary tree traversal. The complexity order of this
   * algorithms in time terms is O(N) and O(N) in space terms because we are using one additional
   * data structure to return the result.
   */
  public List<BinaryNode<Integer>> getRecursive(BinaryNode root) {
    validateBinaryNode(root);

    return getInner(root);
  }

  private List<BinaryNode<Integer>> getInner(BinaryNode<Integer> root) {
    List<BinaryNode<Integer>> result = new LinkedList<BinaryNode<Integer>>();
    if (root != null) {
      result.addAll(getInner(root.getLeft()));
      result.add(root);
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
  public List<BinaryNode<Integer>> getIterative(BinaryNode<Integer> root) {
    validateBinaryNode(root);

    List<BinaryNode<Integer>> result = new LinkedList<BinaryNode<Integer>>();
    Stack<BinaryNode> stack = new Stack<BinaryNode>();
    //Define a pointer to track nodes
    BinaryNode current = root;
    while (!stack.empty() || current != null) {
      if (current != null) {
        //If it is not null, push to stack and go down the tree to left
        stack.push(current);
        current = current.getLeft();
      } else {
        //If no left child pop stack, process the node then let current point to the right
        BinaryNode node = stack.pop();
        result.add(node);
        current = node.getRight();
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
