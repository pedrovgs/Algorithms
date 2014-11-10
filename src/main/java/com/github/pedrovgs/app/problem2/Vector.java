package com.github.pedrovgs.app.problem2;

/**
 * Class created to represent a Vector of integers. This class uses an array as main data structure
 * because the number of elements inside a vector can't change and we can provide constant
 * complexity order O(1) to access random elements inside the array.
 *
 * For simplicity, we are going to assume that the only type of elements we are going to use is
 * int. We could change this implementation to use generics and accept different types if needed.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Vector {

  private final int[] elements;

  public Vector(int... elements) {
    if (elements == null) {
      elements = new int[0];
    }
    this.elements = elements;
  }

  public int getAt(int index) {
    return elements[index];
  }
}
