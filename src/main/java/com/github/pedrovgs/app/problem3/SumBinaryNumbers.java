package com.github.pedrovgs.app.problem3;

/**
 * Given two strings passed as parameters representing two integers in binary format write a
 * function to calculate the sum of this two parameters and return other String with the result in
 * binary format. Input Strings represent positive integers.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SumBinaryNumbers {

  /**
   * To solve this problem we are using 'Integer.parseInt(number,base)' method which complexity
   * order is linear O(N) two times. Then, we are going to calculate the sum of this parsed data
   * and use 'Integer.toBinaryString' which complexity order is also O(N). In both cases, N
   * represents the number of digits of input number in binary representation.
   *
   * This implementation is working and is valid but we have to take into the execution time used
   * to calculate this sum.
   */
  public String sumBinaryNumbersCheating(String n1, String n2) {
    if (n1 == null || n2 == null) {
      throw new IllegalArgumentException("n1 and n2 parameters can't be null");
    }

    int number1, number2;
    try {
      number1 = Integer.parseInt(n1, 2);
      number2 = Integer.parseInt(n2, 2);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "Error parsing input data, review your parameters, should be a valid binary number!");
    }
    int result = number1 + number2;
    return Integer.toBinaryString(result);
  }
}
