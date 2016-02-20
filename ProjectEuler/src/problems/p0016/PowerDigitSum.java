package problems.p0016;

import java.math.BigInteger;

public class PowerDigitSum {
	
	private static final int EXP = 1000;
	private static final int N = 2;
	
	public static void main(String[] args) {
		BigInteger n = new BigInteger(N + ""); 
		n = n.pow(EXP);
		System.out.println(getDigitSum(n));
	}
	
	private static int getDigitSum(BigInteger n)	{
		char[] chars = n.toString().toCharArray();
		int sum = 0;
		for (char c : chars)	{
			sum += c - '0';
		}
		return sum;
	}
	
	
}
