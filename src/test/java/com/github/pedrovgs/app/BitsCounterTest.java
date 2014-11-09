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
    assertEquals(2, bitsCounter.countBitsToOneBasedOnString(1));
  }

  @Test public void numberOfBitsInThreeIsTwo() {
    assertEquals(3, bitsCounter.countBitsToOneBasedOnString(2));
  }

  @Test public void numberOfBitsInSevenIsThree() {
    assertEquals(7, bitsCounter.countBitsToOneBasedOnString(3));
  }
}
