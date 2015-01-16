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
package com.github.pedrovgs.problem63;

import java.util.Stack;

/**
 * How would you design an integer stack which, in addition to push and pop, also has a function
 * min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ConstantComplexityOrderStack {

  /**
   * Approach based on a inner data structure to store the stack of integers and in the same object
   * the current min value we had when the element was pushed. With this approach we get a time
   * complexity order equals to O(1) but a space complexity order equals to O(N) where N is the
   * number of elements in the stack.
   */
  public static class Stack1 extends Stack<MinValue> {

    public void push(int item) {
      int newMin = Math.min(item, getMin());
      super.push(new MinValue(item, newMin));
    }

    public int getMin() {
      if (isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return peek().minValue;
      }
    }
  }

  static class MinValue {
    final int value;
    final int minValue;

    MinValue(int value, int minValue) {
      this.value = value;
      this.minValue = minValue;
    }
  }

  /**
   * Approach based on keep a parallel data structure with the min elements. Doing this we can
   * reduce the number of additional elements stored, but the complexity order is still O(N) in
   * space terms for the worst case. In time terms, the complexity order is equals to O(1).
   */
  public static class Stack2 extends Stack<Integer> {
    Stack<Integer> innerStack = new Stack<Integer>();

    public void push(int item) {
      if (item <= getMin()) {
        innerStack.push(item);
      }
      super.push(item);
    }

    public Integer pop() {
      int value = super.pop();
      if (value == getMin()) {
        innerStack.pop();
      }
      return value;
    }

    public int getMin() {
      if (innerStack.isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return innerStack.peek();
      }
    }
  }
}
