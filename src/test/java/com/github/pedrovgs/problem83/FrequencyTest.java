import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class FrequencyTest {

	@Test
	public void testCheckFrequency() {
		CountNumberFrequency frequency = new CountNumberFrequency();
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5,8,5,8,9,5,3,3,8,8));
		int result = frequency.checkFrequency(numbers, 8);
		int expectedResult = 4;
		assertEquals(expectedResult, result);
		 
	}

}