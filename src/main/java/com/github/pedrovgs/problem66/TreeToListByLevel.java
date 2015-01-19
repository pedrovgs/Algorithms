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
package com.github.pedrovgs.problem66;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class TreeToListByLevel {

  /**
   * Iterative algorithm to resolve this problem. Binary tree traversal by level implemented with a
   * complexity order in time and space terms equivalent to O(N).
   */
  public List<BinaryNode> transform(BinaryNode tree) {
    if (tree == null) {
      return Collections.EMPTY_LIST;
    }

    List<BinaryNode> nodesByLevel = new LinkedList<BinaryNode>();
    Queue<BinaryNode> stack = new LinkedList<BinaryNode>();
    stack.add(tree);
    while (!stack.isEmpty()) {
      BinaryNode node = stack.remove();
      nodesByLevel.add(node);
      if (node.getLeft() != null) {
        stack.add(node.getLeft());
      }
      if (node.getRight() != null) {
        stack.add(node.getRight());
      }
    }
    return nodesByLevel;
  }
}
