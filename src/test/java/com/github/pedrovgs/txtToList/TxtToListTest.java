package com.github.pedrovgs.txtToList;

import org.junit.Test;

import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.util.List;
import java.util.Arrays;

/**
 * This class contains tests for TxtToList.readFileToList method.
 * @author ShoeMaker
 *
 */
public class TxtToListTest {
	
	//Files we are going to use for the test
	TxtToList ttl = new TxtToList();
	String path = "src/test/resources/grades.txt";
	String empty ="src/test/resources/empty.txt";
	
	String[] a = {"1", "3", "4", "6", "2", "4", "7", "8", "10", "9", "5"}; //Expected outcome of the readFileToList test
	List<String> b = Arrays.asList(a);
	/**
	 * This tests if the readFileToList method works correctly. 
	 */
	@Test
	public void test_readFileToList() {
		Assert.assertEquals(b, ttl.readFileToList(path));
	     
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Tests a case of IOException in readFileToList method 
	 */
	@Test
	public void test_readFile_IOException() {
	
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Something went wrong while reading the file. Probably wrong path or file doesn't exist.");
		ttl.readFileToList("asfasdf");
	}
	/**
	 * Tests a case of reading an empty file in readFileToList method 
	 */
	@Test
	public void test_readFile_FileEmpty() {
	
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("File was empty.");
		ttl.readFileToList(empty);
	}
	
	
}