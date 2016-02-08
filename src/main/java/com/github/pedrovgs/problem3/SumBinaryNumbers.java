package com.github.pedrovgs.problem3;

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
        validateInput(n1, n2);

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

    /**
     * To improve the execution time of the previous algorithm we are going to  use how an integer is
     * represented in binary. We are going to go through the binary number calculating the number
     * value and at the same time getting the result. This solution is based on the binary number
     * structure where 101 = 1*2^2 + 0*2^1 + 1*2^0 = 5. With this solution we are not going to use
     * Integer.parseInt(..) method to parse input data.
     *
     * The complexity order of this solution is O(N) in time terms where N is the number of digits in
     * the binary number. Is the same complexity order we had, but the execution time is lower.
     *
     * With this solution we are still using 'Integer.toBinaryString(result)' to get the binary
     * representation.
     */
    public String sumBinaryNumbersBasedOnPowersOfTwo(String n1, String n2) {
        validateInput(n1, n2);

        int result = 0;
        int length = Math.max(n1.length(), n2.length());
        for (int i = 0; i < length; i++) {
            result += getValueAt(n1, i) * Math.pow(2, length - i - 1);
            result += getValueAt(n2, i) * Math.pow(2, length - i - 1);
        }
        return Integer.toBinaryString(result);
    }

    /**
     * We are going to subtract 48 to the char to get the number value from the String. This is
     * going to work because the char set we are using is ASCII.
     */
    private static int getValueAt(String binaryNumber, int index) {
        int value = binaryNumber.charAt(index) - 48;
        if (value < 0 || value > 1) {
            throw new IllegalArgumentException(
                    "Error parsing input data, review your parameters, should be a valid binary number!");
        }
        return value;
    }

    /**
     * This solution is the faster I've found. It's similar to how a human sum two binary numbers.
     *
     * The complexity order of this algorithm is O(N) where N is the number of digits of the biggest
     * binary number. This is the faster implementation because we are not parsing data from binary
     * to integer and then from integer to binary.
     *
     * To solve this problem is needed go through the String from right to left, and take always
     * into account the accumulated value of the sum and carry.
     */
    public String sumBinaryNumbersBasedOnCount(String n1, String n2) {
        validateInput(n1, n2);

        StringBuilder result = new StringBuilder();
        int lengthVal1 = n1.length();
        int lengthVal2 = n2.length();
        int length = Math.max(lengthVal1, lengthVal2);
        int carry = 0;
        int sum = 0;
        int remainder = 0;
        for (int i = 0; i < length; i++) {
            //This is a beautiful trick to avoid IndexOutOfBoundExceptions.
            int digit1 = i >= lengthVal1 ? 0 : n1.charAt(lengthVal1 - i - 1) - '0';
            int digit2 = i >= lengthVal2 ? 0 : n2.charAt(lengthVal2 - i - 1) - '0';

            if (digit1 < 2 && digit2 < 2) {
                sum = digit1 + digit2 + carry;
                carry = sum / 2;
                remainder = sum % 2;
                result.append((char) (remainder + '0'));
            } else {
                throw new IllegalArgumentException(
                        "Error parsing input data, review your parameters, should be a valid binary number!");
            }
        }
        if (carry != 0)
            result.append((char) (carry + '0'));
        return result.reverse().toString();
    }

    private void validateInput(String n1, String n2) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("n1 and n2 parameters can't be null");
        }
    }
}
