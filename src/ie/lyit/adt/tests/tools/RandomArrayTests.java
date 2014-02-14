package ie.lyit.adt.tests.tools;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import ie.lyit.adt.tools.RandomArray;

import org.junit.Test;

/**
 * Random array generator unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RandomArrayTests {
	/**
	 * Tests the random integer array creation
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRandomIntArray() throws Exception {
		// Basic tests (prints out generated elements)
		int[] basic = RandomArray.randomIntArray(10, false, true);
		assertTrue(basic.length == 10);
		for (int element : basic) {
			System.out.println(element);
		}

		// Checks if sorting parameter works
		int[] sorted = RandomArray.randomIntArray(10, true, false);
		int currentMax = Integer.MIN_VALUE;
		for (int element : sorted) {
			assertTrue(element > currentMax || element == Integer.MIN_VALUE);
			currentMax = element;
		}

		// Checks if noDuplicates parameter works
		int[] noDuplicates = RandomArray.randomIntArray(1000, false, false);
		Set<Integer> duplicatesCheck = new LinkedHashSet<Integer>();
		for (int element : noDuplicates) {
			assertTrue(duplicatesCheck.add(element));
		}
	}

	/**
	 * Checks if the empty array size exception get's thrown
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void invalidSizeTest() throws Exception {
		RandomArray.randomIntArray(0, false, false);
	}
}
