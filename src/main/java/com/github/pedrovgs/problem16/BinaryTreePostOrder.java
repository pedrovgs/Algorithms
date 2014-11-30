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
package com.github.pedrovgs.problem16;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, can you write a method to getRecursive a List<BinaryNode> using a post
 * order traversal?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreePostOrder {

  /**
   * Recursive implementation of this binary tree traversal. The complexity order of this
   * algorithms in time terms is O(N) and O(N) in space terms because we are using one additional
   * data structure to return the result.
   */
  public List<BinaryNode> getRecursive(BinaryNode root) {
    validateTree(root);
    return getInner(root);
  }

  private List<BinaryNode> getInner(BinaryNode root) {
    List<BinaryNode> result = new LinkedList<BinaryNode>();
    if (root != null) {
      result.addAll(getInner(root.getLeft()));
      result.addAll(getInner(root.getRight()));
      result.add(root);
    }
    return result;
  }

  public List<BinaryNode> getIterative(BinaryNode root) {
    validateTree(root);
    List<BinaryNode> result = new LinkedList<BinaryNode>();
    Stack<BinaryNode> stack = new Stack<BinaryNode>();
    stack.push(root);

    BinaryNode prev = null;
    while (!stack.empty()) {
      BinaryNode current = stack.peek();

      //Go down the tree. check if current node is leaf, if so, process it and pop stack, otherwise,
      //keep going down
      if (prev == null || prev.getLeft() == current || prev.getRight() == current) {
        //prev == null is the situation for the root node
        if (current.getLeft() != null) {
          stack.push(current.getLeft());
        } else if (current.getRight() != null) {
          stack.push(current.getRight());
        } else {
          stack.pop();
          result.add(current);
        }

        //Go up the tree from left node need to check if there is a right child
        //if yes, push it to stack otherwise, process parent and pop stack
      } else if (current.getLeft() == prev) {
        if (current.getRight() != null) {
          stack.push(current.getRight());
        } else {
          stack.pop();
          result.add(current);
        }

        //Go up the tree from right node after coming back from right node, process parent node
        //and pop stack.
      } else if (current.getRight() == prev) {
        stack.pop();
        result.add(current);
      }

      prev = current;
    }
    return result;
  }

  private void validateTree(BinaryNode root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't pass a null BinaryNode.");
    }
  }
}
