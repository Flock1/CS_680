package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
	@Test
	public void RegularCase() {
		PrimeGenerator pg = new PrimeGenerator(1,20);
		pg.generatePrimes();
		Long expected[] = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
		LinkedList<Long> primes = pg.getPrimes();
		Long[] actual = primes.toArray(new Long[primes.size()]);
		
		int[] intNumbers = new int[actual.length];

		// Loop through all the result numbers
		for(int i = 0; i < actual.length; i++)
		{
		    // Cast to int and put it to the int array
		    intNumbers[i] = actual[i].intValue();
		}
		//assertTrue(pg instanceof PrimeGenerator);
		assertArrayEquals(expected, actual);
		//assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
	}
	@Test
	public void TestRange(){
		int num1 = 10;
		int num2 = 100;
		PrimeGenerator pg = new PrimeGenerator(num1, num2);
		pg.generatePrimes();
		LinkedList<Long> primes = pg.getPrimes();
		System.out.print(primes);
		assertTrue(num1 >= 0 && num2 > num1);

	}

}
