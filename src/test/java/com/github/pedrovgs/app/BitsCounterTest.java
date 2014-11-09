package com.github.pedrovgs.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitsCounterTest {

  private BitsCounter bitsCounter;

  @Before public void setUp() {
    bitsCounter = new BitsCounter();
  }

  @Test public void numberOfBitsInOneIsOne() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnString(1));
  }

  @Test public void numberOfBitsInTwoIsOne() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnString(2));
  }

  @Test public void numberOfBitsInThreeIsTwo() {
    assertEquals(2, bitsCounter.countBitsToOneBasedOnString(3));
  }

  @Test public void numberOfBitsInSevenIsThree() {
    assertEquals(3, bitsCounter.countBitsToOneBasedOnBinaryOperators(7));
  }

  @Test public void numberOfBitsIn1990IsSeven() {
    assertEquals(7, bitsCounter.countBitsToOneBasedOnBinaryOperators(1990));
  }

  @Test public void numberOfBitsInOneIsOneBasedOnBinaryOperator() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnBinaryOperators(1));
  }

  @Test public void numberOfBitsInTwoIsOneBasedOnBinaryOperator() {
    assertEquals(1, bitsCounter.countBitsToOneBasedOnBinaryOperators(2));
  }

  @Test public void numberOfBitsInThreeIsTwoBasedOnBinaryOperator() {
    assertEquals(2, bitsCounter.countBitsToOneBasedOnBinaryOperators(3));
  }

  @Test public void numberOfBitsInSevenIsThreeBasedOnBinaryOperator() {
    assertEquals(3, bitsCounter.countBitsToOneBasedOnBinaryOperators(7));
  }

  @Test public void numberOfBitsIn1990IsSevenBasedOnBinaryOperator() {
    assertEquals(7, bitsCounter.countBitsToOneBasedOnBinaryOperators(1990));
  }
}
