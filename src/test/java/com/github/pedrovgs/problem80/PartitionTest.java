package com.github.pedrovgs.problem80;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;
import com.github.pedrovgs.sortingalgorithms.SortingAlgorithmTest;

public class PartitionTest {
	@Test
	public void testPartition() {
		int[] arr = {2,4,7,3,9,1,8};
		QuickSort quickSortObject = new QuickSort();
		assertTrue("partition incorrect", 5 == quickSortObject.partition(arr, 0, 6));
	}
}
