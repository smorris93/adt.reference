package ie.lyit.adt.tests.algorithms.searching;

import static org.junit.Assert.assertEquals;
import ie.lyit.adt.algorithms.searching.LinearSearch;
import ie.lyit.adt.tools.RandomArray;

import java.util.Random;

import org.junit.Test;

/**
 * Linear search unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class LinearSearchTests {
	/**
	 * Tests the basic functionality of the linear search algorithm
	 * 
	 * @throws Exception
	 */
	@Test
	public void basicTest() throws Exception {
		Random random = new Random();
		int[] randomArray = RandomArray.randomIntArray(1000, false, false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, LinearSearch.linearIntSearch(randomArray,
				randomArray[randomIndex]));
	}

	/**
	 * Tests if the average efficiency of the linear search is n/2
	 * 
	 * @throws Exception
	 */
	@Test
	public void trendingTest() throws Exception {
		int totalComparisons = 0;
		Random random = new Random();

		for (int i = 0; i < 50000; i++) {
			int[] randomArray = RandomArray.randomIntArray(50, false, false);
			int randomIndex = random.nextInt(50);
			int searchIndex = LinearSearch.linearIntSearch(randomArray,
					randomArray[randomIndex]);
			totalComparisons += searchIndex >= 0 ? searchIndex : 50;
			assertEquals(randomIndex, searchIndex);
		}

		System.out.println("Average comparison count was: " + totalComparisons
				/ 50000.0);
		assertEquals(25.0, totalComparisons / 50000.0, 2.5);
	}
}
