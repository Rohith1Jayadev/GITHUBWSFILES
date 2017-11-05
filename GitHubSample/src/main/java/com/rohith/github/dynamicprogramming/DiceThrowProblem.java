package com.rohith.github.dynamicprogramming;

/**
 * Given n dice each with m faces, numbered from 1 to m, find the number of ways
 * to get sum X. X is the summation of values on each face when all the dice are
 * thrown.
 * 
 * @author Rohith Jayadev
 *
 */
public class DiceThrowProblem {

	public static void main(String[] args) {

		
		System.out.println("No of Ways" + diceThrowSum(6,3,8));
		System.out.println("No of Ways" + diceThrowSum(4,3,5)); 
		
	}

	
		
	private static int diceThrowSum(int m , int n ,int sum){
		
		
		
		if(sum<0){
			
			return 0;
		}
		
		if(n==0){
			if(sum!=0){
				
				return 0;
			}
			return 1;
		}
		
		
		int count = 0;
		
		for(int t=1;t<=m;t++){
			
			//System.out.println(t+ " " + n + " " + (sum-t));
			count = count + diceThrowSum(m,n-1,(sum-t));
			
		}
		
		return count;
	}
	
}
