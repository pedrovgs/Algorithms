package com.github.pedrovgs.problem10;

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

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptNullArraysBasedOnSet() {
    removeDuplicates.removeUsingSet(null);
  }

  @Test public void shouldSupportEmptyArraysBasedOnSet() {
    Integer[] array = new Integer[0];

    Integer[] result = removeDuplicates.removeUsingSet(array);

    assertArrayEquals(new Integer[0], result);
  }

  @Test public void shouldReturnAnArrayWithJustOneElementIfInputJustContainsOneElementBasedOnSet() {
    Integer[] array = { 1 };

    Integer[] result = removeDuplicates.removeUsingSet(array);

    Integer[] expected = { 1 };
    assertArrayEquals(expected, result);
  }

  @Test public void shouldSupportArraysWithoutDuplicatedElementsBasedOnSet() {
    Integer[] array = { 1, 2, 3 };

    Integer[] result = removeDuplicates.removeUsingSet(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test
  public void shouldReturnAnArrayWithJustOneElementIfTheArrayIsFullOfTheSameElementBasedOnSet() {
    Integer[] array = { 1, 1, 1, 1, 1 };

    Integer[] result = removeDuplicates.removeUsingSet(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldRemoveDuplicatesIfTheInputIsSortedBasedOnSet() {
    Integer[] array = { 1, 2, 3, 3, 4, 4, 6, 6 };

    Integer[] result = removeDuplicates.removeUsingSet(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldRemoveDuplicatesIfTheInputIsNotSortedBasedOnSet() {
    Integer[] array = { 1, 1, 5, 6, 2, 3 };

    Integer[] result = removeDuplicates.removeUsingSet(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullArraysSorting() {
    removeDuplicates.removeUsingSorting(null);
  }

  @Test public void shouldSupportEmptyArraysSorting() {
    Integer[] array = new Integer[0];

    Integer[] result = removeDuplicates.removeUsingSorting(array);

    assertArrayEquals(new Integer[0], result);
  }

  @Test public void shouldReturnAnArrayWithJustOneElementIfInputJustContainsOneElementSorting() {
    Integer[] array = { 1 };

    Integer[] result = removeDuplicates.removeUsingSorting(array);

    Integer[] expected = { 1 };
    assertArrayEquals(expected, result);
  }

  @Test public void shouldSupportArraysWithoutDuplicatedElementsSorting() {
    Integer[] array = { 1, 2, 3 };

    Integer[] result = removeDuplicates.removeUsingSorting(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldReturnAnArrayWithJustOneElementIfTheArrayIsFullOfTheSameElementSorting() {
    Integer[] array = { 1, 1, 1, 1, 1 };

    Integer[] result = removeDuplicates.removeUsingSorting(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldRemoveDuplicatesIfTheInputIsSortedSorting() {
    Integer[] array = { 1, 2, 3, 3, 4, 4, 6, 6 };

    Integer[] result = removeDuplicates.removeUsingSorting(array);

    assertTrue(containsUniqueElements(result));
  }

  @Test public void shouldRemoveDuplicatesIfTheInputIsNotSortedSorting() {
    Integer[] array = { 1, 1, 5, 6, 2, 3 };

    Integer[] result = removeDuplicates.removeUsingSorting(array);

    assertTrue(containsUniqueElements(result));
  }

  private boolean containsUniqueElements(Integer[] result) {
    Set<Integer> elements = new HashSet<Integer>();
    for (int i : result) {
      if (elements.contains(i)) {
        return false;
      }
    }
    return true;
  }
}
