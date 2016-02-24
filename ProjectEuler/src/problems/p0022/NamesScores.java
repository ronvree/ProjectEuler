package problems.p0022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * Using names.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * What is the total of all the name scores in the file?
 */

public class NamesScores {
	
	private static final String PATH = "src/problems/p0022/p022_names.txt";
	private static BufferedReader reader;
	private static String[] names;
	static	{
		try {
			reader = new BufferedReader(new FileReader(PATH));
			names = reader.readLine().replaceAll("\"", "").split(",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Sort names
		List<String> nameList = new ArrayList<String>();
		for (String name : names)	{
			nameList.add(name);
		}
		nameList = sortNames(nameList);
		// Calculate score
		long sum = 0;
		for (int i = 1; i <= nameList.size(); i++)	{
			sum += i * getLetterScore(nameList.get(i - 1));
		}
		// Print score
		System.out.println(sum);
	}
	
	private static int getLetterScore(String name)	{
		int sum = 0;
		for (char c : name.toCharArray())	{
			sum += c - 'A' + 1;
		}
		return sum;
	}
	
	private static final List<String> sortNames(List<String> names)	{
		return mergeSort(names);
	}
	
	public static List<String> mergeSort(List<String> list)	{
		if (list.size() <= 1)	{
			return list;
		}
		List<String> left = new ArrayList<String>();
		List<String> right = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++)	{
			if (i%2 == 1)	{
				left.add(list.get(i));
			} else {
				right.add(list.get(i));
			}
		}
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	private static List<String> merge(List<String> a, List<String> b)	{
		List<String> result = new ArrayList<String>();
		while(a.size() != 0 && b.size() != 0)	{
			if (smallerThan(a.get(0), b.get(0)) || a.equals(b))	{
				result.add(a.get(0));
				a.remove(0);
			} else	{
				result.add(b.get(0));
				b.remove(0);
			}
		}
		while (a.size() != 0)	{
			result.add(a.get(0));
			a.remove(0);
		}
		while (b.size() != 0)	{
			result.add(b.get(0));
			b.remove(0);
		}
		return result;
	}
	
	
	// Returns a > b
//	private static boolean greaterThan(String a, String b){
//		for (int i = 0; i < Math.min(a.length(), b.length()); i++)	{
//			if (a.charAt(i) > b.charAt(i))	{
//				return true;
//			}
//			if (a.charAt(i) < b.charAt(i))	{
//				return false;
//			}
//		}
//		return a.length() > b.length(); 
//	}
	
	// Returns a < b
	private static boolean smallerThan(String a, String b){
		for (int i = 0; i < Math.min(a.length(), b.length()); i++)	{
			if (a.charAt(i) > b.charAt(i))	{
				return false;
			}
			if (a.charAt(i) < b.charAt(i))	{
				return true;
			}
		}
		return a.length() < b.length(); 
	}
	
	
}
