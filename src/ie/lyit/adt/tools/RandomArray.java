package ie.lyit.adt.tools;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Random array generator
 * 
 * @author markus.korbel
 * 
 */
public class RandomArray {
	/**
	 * Creates a random integer array of the specified size
	 * 
	 * @param size
	 *            The size of the random array
	 * @param sorted
	 *            Should the elements be sorted?
	 * @param allowDuplicates
	 *            Allow duplicate elements in the array?
	 * @return
	 * @throws Exception
	 *             If the array size is invalid
	 */
	public static int[] randomIntArray(int size, boolean sorted,
			boolean allowDuplicates) throws Exception {
		if (size == 0) {
			throw new Exception("Size must be at least 1!");
		}

		Random randomGenerator = new Random();

		if (allowDuplicates) {
			int[] randomArray = new int[size];
			for (int i = 0; i < size; i++) {
				randomArray[i] = randomGenerator.nextInt();
			}

			if (sorted) {
				Arrays.sort(randomArray);
			}

			return randomArray;
		} else {
			Set<Integer> randomSet = new LinkedHashSet<Integer>();
			while (randomSet.size() < size) {
				randomSet.add(randomGenerator.nextInt());
			}

			int[] randomArray = new int[size];
			int index = 0;
			for (Integer element : randomSet) {
				randomArray[index++] = element.intValue();
			}

			if (sorted) {
				Arrays.sort(randomArray);
			}

			return randomArray;
		}
	}
}
