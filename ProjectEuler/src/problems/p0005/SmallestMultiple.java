package problems.p0005;

import java.util.ArrayList;
import java.util.List;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class SmallestMultiple {
	
	private static final int BOUND = 20;
	
	public static void main(String[] args) {
		List<Integer> factors = new ArrayList<Integer>();
		// Add all factors from 2 to BOUND (excluding 1 because everything is divisible by 1)
		for (int i = 2; i <= BOUND; i++)	{
			factors.add(i);
		}
		// Filter factors (everything divisible by 10 is also divisible by 5 and 2)
		List<Integer> toRemove = new ArrayList<Integer>();
		for (int factor : factors)	{
			toRemove.addAll(SmallestMultiple.getFactors(factor));
		}
		factors.removeAll(toRemove);
		// Iterate from BOUND to B!
		long result = -1;
		for (long i = BOUND;; i++)	{
			if (SmallestMultiple.isDivisible(i, factors))	{
				result = i;
				break;
			}
		}
		// Show result
		System.out.println("Result found: " + result);
	}
	
//	public static int factorial(int n) {
//	   int fact = 1; 
//	   for (int i = 1; i <= n; i++) {
//	       fact *= i;
//	   }
//	   return fact;
//	}
	
	public static List<Integer> getFactors(int n)	{
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 2; i <= n/2; i++)	{
			if (n%i == 0)	{
				result.add(i);
			}
		}
		return result;
	}
	
	public static boolean isDivisible(long n, List<Integer> factors)	{
		boolean result = true;
		for (int factor : factors)	{
			result = result && n%factor == 0;
			if (!result)	{
				break;
			}
		}
		return result;
	}
	
}
