package util;

import java.util.ArrayList;
import java.util.List;

public class IntegerSort {
	
	public static List<Integer> mergeSort(List<Integer> list)	{
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
