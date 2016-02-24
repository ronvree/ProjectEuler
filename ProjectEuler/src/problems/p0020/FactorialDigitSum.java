package problems.p0020;

import java.math.BigInteger;

/*
 * 	n! means n*(n - 1)*...*3*2*1
 *  For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800,
 *  and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *  Find the sum of the digits in the number 100!
 */

public class FactorialDigitSum {
	
	private static final int N = 100;
	
	public static void main(String[] args) {
		BigInteger n = new BigInteger(1 + "");
		for (int i = 0; i < N; i++)	{
			n = n.multiply(new BigInteger(N - i + ""));
		}
		int digitSum = 0;
		char[] chars = (n + "").toCharArray();
		for (char c : chars)	{
			digitSum += c - '0';
		}
		System.out.println(digitSum);
	}
	
}
