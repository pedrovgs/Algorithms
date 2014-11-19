package com.github.pedrovgs.app.problem10;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class RemoveDuplicatesTest {

  private RemoveDuplicates removeDuplicates;

  @Before public void setUp() {
    this.removeDuplicates = new RemoveDuplicates();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArrays() {
    removeDuplicates.remove(null);
  }

  @Test public void shouldSupportEmptyArrays() {
    int[] array = new int[0];

    int[] result = removeDuplicates.remove(array);

    assertArrayEquals(new int[0], result);
  }

  @Test public void shouldReturnAnArrayWithJustOneElementIfInputJustContainsOneElement() {
    int[] array = { 1 };

    int[] result = removeDuplicates.remove(array);

    int[] expected = { 1 };
    assertArrayEquals(expected, result);
  }

  @Test public void shouldSupportArraysWithoutDuplicatedElements() {
    int[] array = { 1, 2, 3 };

    int[] result = removeDuplicates.remove(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldReturnAnArrayWithJustOneElementIfTheArrayIsFullOfTheSameElement() {
    int[] array = { 1, 1, 1, 1, 1 };

    int[] result = removeDuplicates.remove(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldRemoveDuplicatesIfTheInputIsSorted() {
    int[] array = { 1, 2, 3, 3, 4, 4, 6, 6 };

    int[] result = removeDuplicates.remove(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldRemoveDuplicatesIfTheInputIsNotSorted() {
    int[] array = { 1, 1, 5, 6, 2, 3 };

    int[] result = removeDuplicates.remove(array);

    assertTrue(containsUniqueElements(result));
  }

  private boolean containsUniqueElements(int[] result) {
    Set<Integer> elements = new HashSet<Integer>();
    for (int i : result) {
      if (elements.contains(i)) {
        return false;
      }
    }
    return true;
  }
}
