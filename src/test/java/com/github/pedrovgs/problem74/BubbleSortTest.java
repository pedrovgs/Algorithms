package com.github.pedrovgs.problem74;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BubbleSortTest {

  private BubbleSort bubbleSort;

  @Before public void setUp() {
    bubbleSort = new BubbleSort();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    bubbleSort.sort(null);
  }

  @Test public void shouldNotModifyArrayIfIsAlreadySorted() {
    int[] input = { 1, 2, 3, 4 };

    bubbleSort.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }

  @Test public void shouldSortArrayWhenTheInputDataIsInDescendingOrder() {
    int[] input = { 4, 3, 2, 1 };

    bubbleSort.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }

  @Test public void shouldSortArrayPartiallySorted() {
    int[] input = { 1, 2, 4, 3 };

    bubbleSort.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }

  @Test public void shouldSortArray() {
    int[] input = { 3, 4, 1, 2 };

    bubbleSort.sort(input);

    int[] expectedArray = { 1, 2, 3, 4 };
    assertArrayEquals(expectedArray, input);
  }
}
