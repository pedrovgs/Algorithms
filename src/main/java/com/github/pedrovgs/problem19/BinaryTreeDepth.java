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
package com.github.pedrovgs.problem19;

import com.github.pedrovgs.binarytree.BinaryNode;

/**
 * Given a Binary Tree passed as argument, can you write a method to calculate the tree depth?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeDepth {

  /**
   * Recursive solution for this problem. The complexity order of this algorithm in time terms is
   * O(N) where N is the number of elements in the binary tree. In space terms, the complexity order
   * of this algorithm is O(1) because we are not using any additional data structure related to the
   * number of nodes in the tree to resolve this problem.
   */
  public int get(BinaryNode root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't pass a null BinaryNode as parameter");
    }
    return getInner(root);
  }

  private int getInner(BinaryNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(getInner(root.getLeft()), getInner(root.getRight()));
    }
  }
}
