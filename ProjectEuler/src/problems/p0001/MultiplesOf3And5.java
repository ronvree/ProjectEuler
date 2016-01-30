package problems.p0001;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class MultiplesOf3And5 {
	
	private static final int C1 = 3;
	private static final int C2 = 5;
	private static final int N = 1000;
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < N; i++)	{
			if (i%C1 == 0 || i%C2 == 0)	{
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	
}
