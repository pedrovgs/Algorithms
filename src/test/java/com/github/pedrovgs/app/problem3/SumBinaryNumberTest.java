package com.github.pedrovgs.app.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SumBinaryNumberTest {

  private SumBinaryNumbers sumBinaryNumbers;

  @Before public void setUp() {
    this.sumBinaryNumbers = new SumBinaryNumbers();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullInputs() {
    sumBinaryNumbers.sumBinaryNumbers(null, null);
  }

  @Test public void zeroPlusZeroEqualsZero() {
    String n1 = "0";
    String n2 = "0";

    String result = sumBinaryNumbers.sumBinaryNumbers(n1, n2);

    assertEquals(0, result);
  }

  @Test public void zeroPlusTwoEqualsTwo() {
    String n1 = "0";
    String n2 = "10";

    String result = sumBinaryNumbers.sumBinaryNumbers(n1, n2);

    assertEquals("10", result);
  }

  @Test public void fivePlusSevenEqualsTwelve() {
    String n1 = "101";
    String n2 = "111";

    String result = sumBinaryNumbers.sumBinaryNumbers(n1, n2);

    assertEquals("1100", result);
  }
}
