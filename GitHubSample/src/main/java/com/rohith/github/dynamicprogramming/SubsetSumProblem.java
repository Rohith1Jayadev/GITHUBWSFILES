package com.rohith.github.dynamicprogramming;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is
 * a subset of the given set with sum equal to given sum.
 * 
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True //There is a
 * subset (4, 5) with sum 9.
 * 
 * @author Rohith Jayadev
 *
 */
public class SubsetSumProblem {

	public static void main(String[] args) {

		int a[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		isSubSetPresent(a, sum);
	}

	private static void isSubSetPresent(int[] a, int sum) {

		boolean isPresent = checkPresent(a, sum, a.length - 1);

		if (isPresent) {

			System.out.println("Sub Array with sum is present");
			return;
		}

		System.out.println("Sub Array with sum is not present");

	}

	private static boolean checkPresent(int[] a, int sum, int i) {

		if (sum == 0) {

			return true;
		}

		if (i == 0 && sum != 0) {

			return false;
		}

		if (a[i] > sum) {

			return checkPresent(a, sum, i - 1);
		}

		return (checkPresent(a, sum, i - 1) || checkPresent(a, sum - a[i], i - 1));
	}

}
