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
package com.github.pedrovgs.problem24;

import com.github.pedrovgs.binarytree.BinaryNode;

/**
 * Given a sorted array full of integers, can you write a method to return a BST?
 *
 * A binary search tree (BST), sometimes also called an ordered or sorted binary tree, is a
 * node-based binary tree data structure where each node has a comparable key (and an associated
 * value) and satisfies the restriction that the key in any node is larger than the keys in all
 * nodes in that node's left sub-tree are smaller than the keys in all nodes in that node's right
 * sub-tree. Each node has no more than two child nodes.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SortedArrayToBST {

  /**
   * Recursive algorithm implemented using a binary search movements. The complexity order of this
   * algorithm in time terms is O(N) where N is the number of elements in the array. In space
   * terms, the complexity order is equivalent because we have to return a binary tree with every
   * element.
   */
  public BinaryNode<Integer> transform(Integer[] sortedArray) {
    if (sortedArray == null || sortedArray.length == 0) {
      throw new IllegalArgumentException("You can't use a null or empty array.");
    }
    return transformToBST(sortedArray, 0, sortedArray.length - 1);
  }

  private static BinaryNode<Integer> transformToBST(Integer[] sortedArray, int bottom, int top) {
    int center = (top + bottom) / 2;
    if (sortedArray.length == 1) {
      return new BinaryNode<Integer>(sortedArray[0]);
    } else if (bottom > top) {
      return null;
    } else {
      BinaryNode node = new BinaryNode<Integer>(sortedArray[center]);
      node.setLeft(transformToBST(sortedArray, bottom, center - 1));
      node.setRight(transformToBST(sortedArray, center + 1, top));
      return node;
    }
  }
}
