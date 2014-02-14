package ie.lyit.adt.tests.algorithms.searching;

import static org.junit.Assert.assertEquals;
import ie.lyit.adt.algorithms.searching.BinarySearch;
import ie.lyit.adt.tools.RandomArray;

import java.util.Random;

import org.junit.Test;

/**
 * Binary search unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BinarySearchTests {

	/**
	 * Tests the basic functionality of the binary search algorithm
	 * 
	 * @throws Exception
	 */
	@Test
	public void basicTest() throws Exception {
		Random random = new Random();
		int[] randomArray = RandomArray.randomIntArray(1000, true, false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, BinarySearch.binaryIntSearch(randomArray,
				randomArray[randomIndex]));
	}

	/**
	 * Tries to demonstrate the log2(n) efficiency
	 * 
	 * @throws Exception
	 */
	@Test
	public void logarithmicTest() throws Exception {
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			int[] randomArray = RandomArray.randomIntArray(1000, true, false);
			int randomIndex = random.nextInt(1000);
			assertEquals(randomIndex, BinarySearch.binaryIntSearch(randomArray,
					randomArray[randomIndex], 0, randomArray.length, true));
		}
	}
}
