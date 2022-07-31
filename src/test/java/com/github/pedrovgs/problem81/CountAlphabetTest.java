package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.CountAlphabet;

public class CountAlphabetTest {

	
	@Test
	public void shouldAlbetoCountAlphabet()
	{
		CountAlphabet calp= new CountAlphabet();
		int output = calp.countA("Jason");
		assertEquals(1,output);
	}
	
}


