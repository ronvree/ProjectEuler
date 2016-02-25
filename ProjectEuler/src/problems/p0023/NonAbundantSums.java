package problems.p0023;

import java.util.ArrayList;
import java.util.List;

/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class NonAbundantSums {
	
	private static final int BOUND = 28123;
	
	public static void main(String[] args) {
		// Find abundant numbers under 28123
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= BOUND; i++)	{
			if (sumList(getProperDivisors(i)) > i)	{
				abundantNumbers.add(i);
			}
		}
		List<Integer> nonAbundantList = new ArrayList<Integer>();
		for (int i = 1; i <= BOUND; i++)	{
			boolean nonAbundant = true;
			for (int j : abundantNumbers)	{
				if (j >= i)	{
					break;
				} else	{
					if (contains(abundantNumbers, i - j))	{
						nonAbundant = false;
						break;
					}
				}
			}
			if (nonAbundant)	{
				nonAbundantList.add(i);
			}
		}
		System.out.println(sumList(nonAbundantList));
	}
	
	private static boolean contains(List<Integer> list, int element)	{
		return binSearch(list, element, 0, list.size() - 1);
	}
	
	private static boolean binSearch(List<Integer> list, int element, int imin, int imax)	{
		if (imax < imin	)	{
			return false;
		} else	{
			int imid = (imin + imax)/2;
			if (list.get(imid) > element)	{
				return binSearch(list, element, imin, imid - 1);
			} else if (list.get(imid) < element)	{
				return binSearch(list, element, imid + 1, imax);
			} else {
				return true;
			}
		}
	}
	
	
	private static final int sumList(List<Integer> numbers){
		int sum = 0;
		for (int number : numbers)	{
			sum += number;
		}
		return sum;
	}
	
	private static List<Integer> getProperDivisors(int n)	{
		List<Integer> divisors = new ArrayList<Integer>();
		divisors.add(1);
		for (int i = n/2; i > 1; i--)	{
			if (n%i == 0)	{
				divisors.add(i);
			}
		}
		return divisors;
	}
	
}
