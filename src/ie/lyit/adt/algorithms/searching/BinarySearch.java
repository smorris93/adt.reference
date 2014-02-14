package ie.lyit.adt.algorithms.searching;

/**
 * Binary search algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BinarySearch {
	/**
	 * Binary integer array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The number to search for
	 * @param iMin
	 *            The minimum index boundary
	 * @param iMax
	 *            The maximum index boundary
	 * @param printNumberOfComparisons
	 *            Should we print the number of comparisons to the console?
	 * @return The index of the item or -1 if the item was not found
	 */
	public static int binaryIntSearch(int[] array, int searchFor, int iMin,
			int iMax, boolean printNumberOfComparisons) {
		int comparisons = 0;
		while (iMax >= iMin) {
			comparisons++;
			int iMid = iMin + ((iMax - iMin) / 2);
			if (array[iMid] == searchFor) {
				if (printNumberOfComparisons) {
					System.out.println("Binary search comparisons: "
							+ comparisons);
				}
				return iMid;
			}

			if (array[iMid] < searchFor) {
				iMin = iMid + 1;
			} else {
				iMax = iMid - 1;
			}
		}

		if (printNumberOfComparisons) {
			System.out.println("Binary search comparisons: "
					+ comparisons);
		}
		return -1;
	}

	/**
	 * Binary integer array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The number to search for
	 * @return The index of the item or -1 if the item was not found
	 */
	public static int binaryIntSearch(int[] array, int searchFor) {
		return binaryIntSearch(array, searchFor, 0, array.length, false);
	}
}
