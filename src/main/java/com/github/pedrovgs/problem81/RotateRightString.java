package com.github.pedrovgs.problem81;

import java.util.Arrays;

public class RotateRightString {
    public static String rotateLeft(String str, int d){
        char[] result = new char[str.length()];
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++)
            result[(i+(data.length-d)) % data.length ] = data[i];
        return Arrays.toString(result);
    }
}
