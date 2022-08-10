import java.util.*;

public class CountNumberFrequency {
	
	public int checkFrequency(ArrayList<Integer> numbers, int num2check) {
	
	    // Count the frequency of a number in numbers
	    int count = Collections.frequency(numbers, num2check);
	    System.out.println("Count of "+num2check+": " + count);
	    
	    return count;
	}
}