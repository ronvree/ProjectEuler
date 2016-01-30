package problems.p0003;
	
/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

public class LargestPrimeFactor {
	
	private static final long N = 600851475143L;
	
	public static void main(String[] args) {
		long maxFactor = -1;
		for (long i = N/2; i > 1; i-=2)	{
			if (N%i == 0)	{
				maxFactor = i;
				break;
			}
		}
		System.out.println(maxFactor);
		// Turns out to be 8462696833 (NOT PRIME, LARGEST PRIME FACTOR: 6857)
		
	}
	
	/*
	 * l should be uneven
	 */
//	private long getLargestFactor(long l)	{
//		long maxFactor = -1;
//		for (long i = l/2; i > 1; i-=2)	{
//			if (N%i == 0)	{
//				maxFactor = i;
//				break;
//			}
//		}
//		return maxFactor;
//	}
	
}
