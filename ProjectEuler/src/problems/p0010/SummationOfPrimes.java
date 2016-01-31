package problems.p0010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

public class SummationOfPrimes {
	
	private static final String FILENAME = "src/util/AtkinPrimes.txt";
	private static final int LIMIT = 2000000;
	
	public static void main(String[] args) {
		// Read primes from generated list
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILENAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// get sum sum
		long sum = 0;
		try {
			while (reader.ready())	{
				int prime = Integer.valueOf(reader.readLine());
				if (prime < LIMIT)	{
					sum += prime;
				} else	{
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sum);
	}
	
}
