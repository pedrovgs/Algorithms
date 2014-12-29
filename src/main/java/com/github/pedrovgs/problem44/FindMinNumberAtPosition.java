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
package com.github.pedrovgs.problem44;

import com.github.pedrovgs.binarytree.BinaryNode;
import com.github.pedrovgs.problem15.BinaryTreeInOrder;
import java.util.List;

/**
 * Given a Binary Search Tree, can you write a method to obtain the nTH min element?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class FindMinNumberAtPosition {

  private final BinaryTreeInOrder inOrder;

  public FindMinNumberAtPosition() {
    this.inOrder = new BinaryTreeInOrder();
  }

  /**
   * This algorithm has a complexity order in space and time terms of O(N) where N is the number of
   * elements in the tree. It's based on the property of BST. If you go through a BST using a
   * in order tour you'll get an ordered list of elements.
   */
  public Integer find(BinaryNode<Integer> root, int position) {
    validateInputData(root, position);
    List<BinaryNode<Integer>> orderedElements = getOrderedElements(root);
    validatePosition(position, orderedElements);
    return orderedElements.get(position - 1).getData();
  }

  private List<BinaryNode<Integer>> getOrderedElements(BinaryNode root) {
    return inOrder.getRecursive(root);
  }

  private void validatePosition(int position, List<BinaryNode<Integer>> orderedElements) {
    if (position >= orderedElements.size()) {
      throw new IllegalArgumentException(
          "The number of elements in the tree is minor than the position requested.");
    }
  }

  private void validateInputData(BinaryNode<Integer> root, int position) {
    if (root == null || position < 0) {
      throw new IllegalArgumentException("You can't pass null binary trees or negative positions.");
    }
  }
}
