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
package com.github.pedrovgs.problem65;

import com.github.pedrovgs.binarytree.BinaryNode;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a
 * balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IsTreeBalanced {

  /**
   * Recursive algorithm to check if a binary tree is balanced. The complexity order in time terms
   * of this algorithm is equals to O(N) where N is the number of nodes in the binary tree. In
   * space terms, the complexity order is O(1) because we are not using any auxiliary data
   * structure to resolve this problem. This algorithm is based on the tree height because the
   * balanced tree definition is based on this.
   */
  public boolean check(BinaryNode root) {
    if (root == null) {
      return true;
    } else {
      int heightDifference = getRootHeight(root.getLeft()) - getRootHeight(root.getRight());
      return Math.abs(heightDifference) <= 1;
    }
  }

  private int getRootHeight(BinaryNode tree) {
    if (tree == null) {
      return 0;
    } else {
      return 1 + Math.max(getRootHeight(tree.getLeft()), getRootHeight(tree.getRight()));
    }
  }
}
