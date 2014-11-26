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
package com.github.pedrovgs.app.problem16;

import com.github.pedrovgs.app.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;

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
  public List<BinaryNode> getRecursive(BinaryNode<Integer> root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't pass a null BinaryNode.");
    }
    return getInner(root);
  }

  private List<BinaryNode> getInner(BinaryNode<Integer> root) {
    List<BinaryNode> result = new LinkedList<BinaryNode>();
    if (root != null) {
      result.addAll(getInner(root.getLeft()));
      result.addAll(getInner(root.getRight()));
      result.add(root);
    }
    return result;
  }
}
