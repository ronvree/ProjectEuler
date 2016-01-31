package util;

import java.util.ArrayList;
import java.util.List;

public class LongSort {
	
	public static List<Long> mergeSort(List<Long> list)	{
		if (list.size() <= 1)	{
			return list;
		}
		List<Long> left = new ArrayList<Long>();
		List<Long> right = new ArrayList<Long>();
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
	
	private static List<Long> merge(List<Long> a, List<Long> b)	{
		List<Long> result = new ArrayList<Long>();
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
