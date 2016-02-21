package util;

import java.util.ArrayList;
import java.util.List;

/*
 * Sorts lists of Strings in alphabetical order
 */
public class StringSort {
	
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
	
//	 Returns a > b
	public static boolean greaterThan(String a, String b){
		for (int i = 0; i < Math.min(a.length(), b.length()); i++)	{
			if (a.charAt(i) > b.charAt(i))	{
				return true;
			}
			if (a.charAt(i) < b.charAt(i))	{
				return false;
			}
		}
		return false; 
	}
	
	// Returns a < b
	public static boolean smallerThan(String a, String b){
		for (int i = 0; i < Math.min(a.length(), b.length()); i++)	{
			if (a.charAt(i) > b.charAt(i))	{
				return false;
			}
			if (a.charAt(i) < b.charAt(i))	{
				return true;
			}
		}
		return false; 
	}
	
}
