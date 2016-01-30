package problems.p0006;

import java.util.ArrayList;
import java.util.List;

/*
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class SumSquareDifference {
	
	private static final int BOUND = 100;
	
	public static void main(String[] args) {
		// Create all numbers
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= BOUND; i++)	{
			numbers.add(i);
		}
		// Get sum of numbers
		int sum = SumSquareDifference.sum(numbers);
		
		// Get squares
		List<Integer> squares = SumSquareDifference.squareList(numbers);
		int squaresSum = SumSquareDifference.sum(squares);
		
		// Show result
		System.out.println(sum * sum - squaresSum);
		
	}
	
	private static final int sum(List<Integer> numbers)	{
		int sum = 0;
		for (int number : numbers)	{
			sum += number;
		}
		return sum;
	}
	
	private static List<Integer> squareList(List<Integer> numbers)	{
		List<Integer> result = new ArrayList<Integer>();
		for (int number : numbers)	{
			result.add(number * number);
		}
		return result;
	}
	
}
