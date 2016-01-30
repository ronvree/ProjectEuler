package problems.p0007;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 */

public class Prime10001 {
	
	private static final String FILENAME = "src/util/AtkinPrimes.txt";
	private static final int INDEX = 10001;
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILENAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Stream<String> lines = reader.lines();
		System.out.println(lines.toArray()[INDEX - 1]);
	}
	
}
