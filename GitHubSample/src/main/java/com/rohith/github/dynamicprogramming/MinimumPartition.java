package com.rohith.github.dynamicprogramming;

/**
 * 
 * 
 * 
 * This Algorithm finds the minimum difference that can be obtained by
 * 
 * dividing a given array into two sub partitions
 * 
 * 
 * 
 * @author Rohith Jayadev
 *
 */
public class MinimumPartition {

	public static void main(String[] args) {

		int arr[] = { 1, 6, 14, 5 };

		minPartition(arr);
	}

	public static void minPartition(int[] array) {

		int totalSum = 0;

		if (array.length <= 0) {
			System.out.println("No Minimum Sum Calculations Possible");
			return;
		}
		for (int i = 0; i < array.length; i++) {

			totalSum = totalSum + array[i];
		}

		int min = findMin(array, array.length - 1, totalSum, 0);
		
		System.out.println("Minimum Difference is " + min);
	}

	/**
	 * 
	 * @param array
	 * @param i
	 *            -> current position of the value
	 * @param totalSum
	 *            -> total sum of all the digits
	 * @param j
	 *            -> sum Calculated so far by the set of numbers selected
	 * @return
	 */
	private static int findMin(int[] array, int i, int totalSum, int sumSoFar) {

		if (i == 0) {

			return Math.abs((totalSum - sumSoFar) - sumSoFar);
		}

		// The Minimum Difference is always the Minimum obtained by including a
		// particular value and calculating the other and by not including and
		// calculating
		return Math.min(findMin(array, i - 1, totalSum, sumSoFar + array[i]),
				findMin(array, i - 1, totalSum, sumSoFar));
	}

}
