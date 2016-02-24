package problems.p0021;

import java.util.ArrayList;
import java.util.List;

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class AmicableNumbers {
	
	private static final int BOUND = 10000;
	
	public static void main(String[] args) {
		List<Integer> amicableNumbers = new ArrayList<Integer>();
		List<Integer> divisorSums = new ArrayList<Integer>();
		divisorSums.add(null);
		for (int i = 1; i < BOUND; i++)	{
			divisorSums.add(d(i));
		}
		for (int i = 1; i < BOUND; i += 1 )	{
			for (int j = i; j < BOUND; j += 1)	{
				if (i != j && divisorSums.get(i) == j && divisorSums.get(j) == i)	{
					amicableNumbers.add(i);
					amicableNumbers.add(j);
				}
			}
		}
		System.out.println(sumList(amicableNumbers));
	}
	
	private static int d(int n)	{
		return sumList(getProperDivisors(n));
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
