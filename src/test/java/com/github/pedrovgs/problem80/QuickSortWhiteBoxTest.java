package com.github.pedrovgs.problem80;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortWhiteBoxTest extends TestCase {
    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    // Helper method to access private method in QuickSort Class
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object[] parameters) throws Exception {
        Method method = QuickSort.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(quickSort, parameters);
    }

    // Test sort method with valid input to cover validateInput, quickSort, partition, and swap
    @Test
    public void testSortValidInput() {
        int[] numbers = {3, 6, 8, 10, 1, 2, 1};
        quickSort.sort(numbers);
        assertArrayEquals(new int[]{1, 1, 2, 3, 6, 8, 10}, numbers);
    }

    // Test validateInput with null input to cover the exception branch
    @Test
    public void testValidateInputNull() {
        try {
            quickSort.sort(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Test passes
        }
    }

    // Test partition method to ensure the pivoting logic works
    @Test
    public void testPartition() throws Exception {
        int[] numbers = {3, 6, 8, 10, 1, 2, 1};
        int pivotIndex = (int) invokePrivateMethod("partition", new Class[]{int[].class, int.class, int.class}, new Object[]{numbers, 0, numbers.length - 1});

        assertTrue(pivotIndex >= 0 && pivotIndex < numbers.length);

        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(numbers[i] <= numbers[pivotIndex]);
        }
        for (int i = pivotIndex + 1; i < numbers.length; i++) {
            assertTrue(numbers[i] > numbers[pivotIndex]);
        }
    }

    // Test quickSort with left < right branch
    @Test
    public void testQuickSortBranch() throws Exception {
        int[] numbers = {3, 6, 8, 10, 1, 2, 1};
        invokePrivateMethod("quickSort", new Class[]{int[].class, int.class, int.class}, new Object[]{numbers, 0, numbers.length - 1});
        assertArrayEquals(new int[]{1, 1, 2, 3, 6, 8, 10}, numbers);
    }

    // Testing quickSort method will return unsorted if array has single element
    @Test
    public void testQuickSortNotCalledIfArrayHasSingleElement() {
        int[] numbers = {999};
        quickSort.sort(numbers);
        assertArrayEquals(new int[]{999}, numbers);
    }

}