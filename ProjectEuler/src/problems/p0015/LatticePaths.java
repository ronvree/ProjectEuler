package problems.p0015;

import java.math.BigInteger;

/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 */

public class LatticePaths {
	
	private static final int ROWS = 20;
	private static final int COLUMNS = 20;
	
	public static void main(String[] args) {
		// Each path will have to contain a <ROWS> amount of steps downwards and <COLUMNS> steps to the right. How many permutations exist?
		// 40!/(20!*20!)
		BigInteger answer = new BigInteger(fact(ROWS + COLUMNS) + "");
		answer = answer.divide(fact(ROWS));
		answer = answer.divide(fact(COLUMNS));
		System.out.println(answer);
	}
	
	private static final BigInteger fact(int n)	{
		BigInteger answer = new BigInteger("1");
		for (int i = 0; i < n; i++)	{
			answer = answer.multiply(new BigInteger((n - i) + ""));
		}
		return answer;
	}
	
	
}
