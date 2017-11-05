package com.rohith.github.dynamicprogramming;

/**
 * Print the Unique Elements in an array with time complexity of O(n) and space
 * Complexity O(1)
 * 
 * Microsoft Experienced Round 1
 * 
 * @author Rohith Jayadev
 *
 */
public class UniqueElementsInSortedArray {

	public static void main(String[] args) {

		int[] a = { 1,2,3,4,5,6,7};

		printNonDublicates(a, 0, 0);

	}

	private static void printNonDublicates(int[] a, int current, int last) {

		if (current >= a.length) {

			return;
		}

		if (current == 0) {

			System.out.print(a[current] + " ");
			printNonDublicates(a, current + 1, current);
			return;
		}

		if (a[current] != a[last]) {

			System.out.print(a[current] + " ");
		}

		
		printNonDublicates(a, current+1, current);
		
		return;
	}

}
