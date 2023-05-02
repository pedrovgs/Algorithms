package com.github.pedrovgs.problem80;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import junit.framework.AssertionFailedError;
import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;
import com.github.pedrovgs.sortingalgorithms.SortingAlgorithmTest;

public class PartitionTest {
	@Test
	// Partition 1: array with multiple positive elements
	public void testMultiplePositiveElements() {
		int[] arr = {2,4,7,3,9,1,8};
		QuickSort quickSortObject = new QuickSort();
		assertTrue("Error in partition() method: array with multiple positive elements", 5 == quickSortObject.partition(arr, 0, 6));
	}

	@Test
	// Partition 2: array with multiple negative elements
	public void testMultipleNegativeElements() {
		int[] arr = {-2,-4,-7,-3,-9,-1,-8};
		QuickSort quickSortObject = new QuickSort();
		assertTrue("Error in partition() method: array with multiple negative elements", 1 == quickSortObject.partition(arr, 0, 6));
	}
	
	@Test
	// Partition 3: array with multiple mixed elements
	public void testMultipleMixedElements() {
		int[] arr = {-2,4,7,-3,-9,1,8};
		QuickSort quickSortObject = new QuickSort();
		assertTrue("Error in partition() method: array with multiple mixed elements", 6 == quickSortObject.partition(arr, 0, 6));
	}
	
	@Test
	// Partition 4: array with no element
	public void testNoElement() {
		int[] arr = {};
		QuickSort quickSortObject = new QuickSort();
		try {
			quickSortObject.partition(arr, 0, 0);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new AssertionFailedError (e.getMessage());
		}
	}
	
	@Test
	// Partition 5: array with one element
	public void testOneElement() {
		int[] arr = {2};
		QuickSort quickSortObject = new QuickSort();
		try {
			quickSortObject.partition(arr, 0, 1);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new AssertionFailedError (e.getMessage());
		}
	}
}
