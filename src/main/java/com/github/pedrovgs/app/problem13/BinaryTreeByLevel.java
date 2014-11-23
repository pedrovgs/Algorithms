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
package com.github.pedrovgs.app.problem13;

import com.github.pedrovgs.app.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, can you write a method to return a list of nodes by level?
 * And without any additional data structure?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeByLevel {

  /**
   * Add implementation based on an additional data structure, one queue which implementation is a
   * LinkedList. We we are going to do is add elements of the tree to the queue and one by one
   * evaluate it adding more binary nodes to the queue if exist. The complexity order in time terms
   * is O(N) where N is the number of elements in the tree. The complexity order in space terms is
   * O(N) where N is the number of elements in the tree because we are going to store every node in
   * a queue.
   */
  public List<BinaryNode> getUsingQueue(BinaryNode root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't use null BinaryNodes as argument.");
    }

    List<BinaryNode> result = new LinkedList<BinaryNode>();
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode binaryNode = queue.remove();
      result.add(binaryNode);
      if (binaryNode.getLeft() != null) queue.add(binaryNode.getLeft());
      if (binaryNode.getRight() != null) queue.add(binaryNode.getRight());
    }
    return result;
  }
}
