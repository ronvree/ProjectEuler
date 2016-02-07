package problems.p0014;

import java.util.ArrayList;
import java.util.List;

/*
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 */

public class LongestCollatzSequence {
	
	private static final int BOUND = 1000000;
	private static final int END = 1;
	
	public static void main(String[] args) {
		/*
		 * The entries of this list are the collatz numbers of its index
		 */
		List<Long> collatzNumbers = new ArrayList<Long>();
		// Fill list
		collatzNumbers.add(null);
		for (int n = 1; n < BOUND; n++)	{
			collatzNumbers.add(getNextCollatz(n));
		}
		// Follow sequence for all n under BOUND
		int maxLength = -1;
		int maxStart = -1;
		for (int n = 1; n < BOUND; n++)	{
			long current = n;
			int length = 1;
			while (current != END)	{
				if (collatzNumbers.size() > current)	{
					current = collatzNumbers.get((int) current);
				} else	{
					current = getNextCollatz(current);
				}
				length++;
			}
			if (length > maxLength)	{
				maxLength = length;
				maxStart = n;
			}
		}
		System.out.println("Max length: " + maxLength);
		System.out.println("Start nr: " + maxStart);
	}
	
	private static long getNextCollatz(long n)	{
		if (isOdd(n)){
			return getOddCollatz(n);
		} else {
			return getEvenCollatz(n);
		}
	}
	
	private static long getEvenCollatz(long n)	{
		return n/2;
	}
	
	private static long getOddCollatz(long n)	{
		return 3*n + 1;
	}
	
	private static boolean isOdd(long n)	{
		return n%2 == 1;
	}
	
}
