package problems.p0004;

import java.util.ArrayList;
import java.util.List;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class LargestPalindromeProduct {
	
	private static final int BOUND1 = 1000;
	private static final int BOUND2 = 1000;
	
	public static void main(String[] args) {
		List<Integer> palindromes = new ArrayList<Integer>();
		
		for (int i = BOUND1 - 1; i >= 0; i--)	{
			for (int j = BOUND2 - 1; j >= 0; j--)	{
				int product = i*j;
				if (LargestPalindromeProduct.isPalindrome(product))	{
					System.out.println(i + " * " + j + " = " + product);
					palindromes.add(product);
				}
			}
		}
		palindromes = LargestPalindromeProduct.mergeSort(palindromes);
		System.out.println("Largest: " + palindromes.get(palindromes.size() - 1));
	}
	
	
	private static boolean isPalindrome(int number)	{
		List<Character> chars = new ArrayList<Character>();
		char[] charArray = Integer.toString(number).toCharArray();
		for (char c : charArray)	{
			chars.add(c);
		}
		boolean result = true;
		int half = chars.size()/2;
		for (int i = 0; i < half; i++)	{
			result = result && chars.get(0).equals(chars.get(chars.size() - 1));
			chars = chars.subList(1, chars.size() - 1);
		}
		return result;
	}
	
	private static List<Integer> mergeSort(List<Integer> list)	{
		if (list.size() <= 1)	{
			return list;
		}
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
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
	
	private static List<Integer> merge(List<Integer> a, List<Integer> b)	{
		List<Integer> result = new ArrayList<Integer>();
		while(a.size() != 0 && b.size() != 0)	{
			if (a.get(0) <= b.get(0))	{
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
	
	
}
