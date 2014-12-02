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
package com.github.pedrovgs.problem21;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a BinaryTree and two nodes, can you write a method to find the lowest common ancestor of
 * this nodes?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class LowestCommonAncestor {

  /**
   * Recursive implementation for this problem. The complexity order in time terms of this
   * algorithm is O(N) where  N is the number of nodes in the tree. In space terms, the complexity
   * order of this algorithm is O(1) because we are not using any auxiliary data structure to
   * resolve this problem.
   */
  public BinaryNode getRecursive(BinaryNode root, BinaryNode n1, BinaryNode n2) {
    validateInput(root, n1, n2);
    return getRecursiveInner(root, n1, n2);
  }

  private BinaryNode getRecursiveInner(BinaryNode root, BinaryNode n1, BinaryNode n2) {
    if (root == null) {
      return null;
    } else {
      if (root == n1 || root == n2) {
        return root;
      }
      BinaryNode leftBranch = getRecursiveInner(root.getLeft(), n1, n2);
      BinaryNode rightBranch = getRecursiveInner(root.getRight(), n1, n2);
      if (leftBranch != null && rightBranch != null) {
        return root;
      }
      return leftBranch != null ? leftBranch : rightBranch;
    }
  }

  /**
   * Iterative solution for this problem. The complexity order of this algorithm is the same in
   * memory terms, O(N), but is worst in space terms because we are using a list of BinaryNodes
   * that is going to suppose O(N) for space terms where N is the path to the element.
   *
   * This algorithm is based on find the path of two nodes given a root node and compare both paths
   * to find the first non common element and return the previous node, the lowest common ancestor.
   */
  public BinaryNode getIterative(BinaryNode root, BinaryNode n1, BinaryNode n2) {
    validateInput(root, n1, n2);

    List<BinaryNode> pathToA = getPathTo(root, n1);
    List<BinaryNode> pathToB = getPathTo(root, n2);
    BinaryNode result = null;
    int size = Math.min(pathToA.size(), pathToB.size());
    for (int i = 0; i < size; i++) {
      if (pathToA.get(i) != pathToB.get(i)) {
        result = pathToA.get(i - 1);
        break;
      }
    }
    return result;
  }

  private static List<BinaryNode> getPathTo(BinaryNode root, BinaryNode target) {

    List<BinaryNode> path = new LinkedList<BinaryNode>();
    if (root == target) {
      path.add(target);
    } else {
      if (root.getLeft() == null && root.getRight() == null) {
        return null;
      }
      if (root.getLeft() != null) {
        List<BinaryNode> pathTo = getPathTo(root.getLeft(), target);
        if (pathTo != null) {
          path.add(root);
          path.addAll(getPathTo(root.getLeft(), target));
        }
      }
      if (root.getRight() != null) {
        List<BinaryNode> pathTo = getPathTo(root.getRight(), target);
        if (pathTo != null) {
          path.add(root);
          path.addAll(pathTo);
        }
      }
    }
    return path;
  }

  private void validateInput(BinaryNode root, BinaryNode n1, BinaryNode n2) {
    if (root == null || n1 == null || n2 == null) {
      throw new IllegalArgumentException("You can't pass null elements as input.");
    }
  }
}
