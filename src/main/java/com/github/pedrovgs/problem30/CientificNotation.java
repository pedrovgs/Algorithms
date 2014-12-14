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
package com.github.pedrovgs.problem30;

/**
 * Given an String containing a number expressed using cientific notation, can you write a method
 * to
 * return the value of that number?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class CientificNotation {

  public long calculate(String number) {
    if (number == null || number.indexOf("E") == -1) {
      throw new IllegalArgumentException("Invalid format for number " + number);
    }
    //Split number using E
    String[] splittedNumber = number.split("E");
    //Parse left part using double class.
    double first = Double.parseDouble(splittedNumber[0]);
    //Get the sign
    int sign = splittedNumber[1].charAt(0) == '+' ? 1 : -1;
    //Get the pow of 10 E+9 = 10^9
    int pow = Integer.parseInt(splittedNumber[1].substring(1, splittedNumber[1].length()));
    //Calculate result and create the long value using Double class.
    //You have to use Double class because first part of the number is a double.
    Double result = sign * first * Math.pow(10, pow);
    return result.longValue();
  }
}
