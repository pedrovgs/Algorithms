package com.github.pedrovgs.problem74;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest2 {
    @Test
    public void Intsort(){
        int[] input = { 1, 2, 4, 3 };
        int[] expectedArray = { 1, 2, 3, 4 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(input);
        assertArrayEquals(expectedArray,input);
    }

    @Test
    public void Doublesort(){
        int[] input = {-100,63,-62,6};
        int[] expectedArray = { 1, 2, 3, 4 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(input);
        assertArrayEquals(expectedArray,input);
    }

    @Test
    public void Randomsort(){
        int[] input = { 5,-541,56,45,26};
        int[] expectedArray = { 1, 2, 3, 4 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(input);
        assertArrayEquals(expectedArray,input);
    }

    @Test
    public void RanDomsort(){
        int[] input = { 10,559,-65,622,-65,-6};
        int[] expectedArray = { 1, 2, 3, 4 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(input);
        assertArrayEquals(expectedArray,input);
    }


}