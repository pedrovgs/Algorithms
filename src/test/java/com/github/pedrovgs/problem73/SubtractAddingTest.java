package com.github.pedrovgs.problem73;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SubtractAddingTest {

  private SubtractAdding subtractAdding;

  @Before public void setUp() {
    subtractAdding = new SubtractAdding();
  }

  @Test public void shouldReturnZeroIfInputsAreZero() {
    int inputA = 0;
    int inputB = 0;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(0, result);
  }

  @Test public void shouldReturnZeroIfInputsAreEquals() {
    int inputA = 30;
    int inputB = 30;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(0, result);
  }

  @Test public void shouldReturnAPositiveResultIfFirstInputIsGreaterThanTheSecondOne() {
    int inputA = 33;
    int inputB = 30;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(3, result);
  }

  @Test public void shouldReturnANegativeResultIfFirstInputIsLessThanTheSecondOne() {
    int inputA = 30;
    int inputB = 35;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(-5, result);
  }

  @Test public void shouldCalculateTheCorrectSubtractionIfOneOfTheIntegersIsNegative() {
    int inputA = 30;
    int inputB = -35;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(65, result);
  }

  @Test public void shouldCalculateTheCorrectSubttractionIfBothIntegersAreNegative() {
    int inputA = -30;
    int inputB = -35;

    int result = subtractAdding.subtract(inputA, inputB);

    assertEquals(5, result);
  }
}
