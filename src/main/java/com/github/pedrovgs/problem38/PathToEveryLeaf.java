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
package com.github.pedrovgs.problem38;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, can you write a method to calculate every path to every leaf in the tree.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PathToEveryLeaf {

  /**
   * Recursive algorithm to solve this problem. The complexity order of this algorithm is O(N)
   * where N is the number of elements in the array in time and space terms.
   */
  public List<List<BinaryNode>> calculate(BinaryNode<Integer> root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't pass a null instance of BinaryNode");
    }
    return calculatePathToLeafs(root, new LinkedList<BinaryNode>());
  }

  private static List<List<BinaryNode>> calculatePathToLeafs(BinaryNode<Integer> root,
      List<BinaryNode> path) {
    List<List<BinaryNode>> paths = new LinkedList<List<BinaryNode>>();
    if (root == null) {
      return paths;
    } else if (root.getLeft() == null && root.getRight() == null) {
      path.add(root);
      paths.add(path);
      return paths;
    } else {
      path.add(root);
      paths.addAll(calculatePathToLeafs(root.getLeft(), new LinkedList<BinaryNode>(path)));
      paths.addAll(calculatePathToLeafs(root.getRight(), new LinkedList<BinaryNode>(path)));
      return paths;
    }
  }
}
