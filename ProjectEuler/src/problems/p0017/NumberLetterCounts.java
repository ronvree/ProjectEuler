package problems.p0017;

import java.util.Arrays;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 */

public class NumberLetterCounts {
	
	private static final int MAXNROFDIGITS = 3;
	
	public static void main(String[] args) {
		NumberLetterCounts count = new NumberLetterCounts();
		int sum = 0;
		for (int i = 1; i < Math.pow(10, MAXNROFDIGITS); i++)	{
			sum += count.getName(i).toCharArray().length;
			System.out.println(count.getName(i));
		}
		System.out.println("onethousand");	
		sum += "onethousand".toCharArray().length;
		System.out.println(sum);
	}
	
	private String getName(int n)	{
		// Catch all special cases:
		if (n == 0)	{
			return "zero";
		}
		if (n > 9 && n < 20)	{
			return catchTeens(n);
		}
		// Keep track of which additions are required
		String[] additions = new String[]{"hundred", "", ""};
		// Make sure number is three digits long (remove digits/add zeroes)
		char[] chars = (n + "").toCharArray();
		while (chars.length > MAXNROFDIGITS)	{
			chars = Arrays.copyOfRange(chars, 1, chars.length);
		}
		if (chars.length == 1)	{
			char[] zeroes = new char[]{'0', '0', '0'};
			zeroes[2] = chars[0];
			chars = zeroes;
			additions[0] = "";
		}
		if (chars.length == 2)	{
			char[] zeroes = new char[]{'0', '0', '0'};
			zeroes[2] = chars[1];
			zeroes[1] = chars[0];
			chars = zeroes;
			additions[0] = "";
		}
		// Check if "and" should be added. (Example: Nine-hundred .. Nine-hundred and one)
		if (chars[0] != '0')	{
			boolean addAnd = false;
			for (int i = 1; i < chars.length; i++)	{
				addAnd = addAnd || chars[i] != '0';
			}
			if (addAnd)	{
				additions[0] += "and";
			}
		}
		// Create word
		String name = "";
		for (int i = 0; i < chars.length; i++)	{
			Number no = getNumberObject(chars[i]);
			name += no.getByIndex(i) + additions[i];
			if (i == 1 && no instanceof One)	{
				name += catchTeens(chars[2] - '0' + 10);
				break;
			}
		}
		return name;
	}
	
	private String catchTeens(int i){
		switch(i)	{
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		default:
			return " [ " + i + " is not in range of catchTeens]";
		}
	}
	
	private Number getNumberObject(char c)	{
		switch(c)	{
		case '0':
			return new Zero();
		case '1':
			return new One();
		case '2':
			return new Two();
		case '3':
			return new Three();
		case '4':
			return new Four();
		case '5':
			return new Five();
		case '6':
			return new Six();
		case '7':
			return new Seven();
		case '8':
			return new Eight();
		case '9':
			return new Nine();
		default:
			return null;
		}
	}
	
	private abstract class Number	{
		protected String one;
		protected String two;
		
		private String getByIndex(int i)	{
			switch(i)	{
			case 0:
				return this.one;
			case 1:
				return this.two;
			case 2:
				return this.one;
			default:
				return null;
			}
		}
		
	}
	
	private class One extends Number	{
		private One()	{
			this.one = "one";
			this.two = "";
		}
	}
	
	private class Two extends Number	{
		private Two()	{
			this.one = "two";
			this.two = "twenty";
		}
	}
	
	private class Three extends Number	{
		private Three()	{
			this.one = "three";
			this.two = "thirty";
		}
	}
	
	private class Four extends Number	{
		private Four()	{
			this.one = "four";
			this.two = "forty";
		}
	}
	
	private class Five extends Number	{
		private Five()	{
			this.one = "five";
			this.two = "fifty";
		}
	}
	
	private class Six extends Number	{
		private Six()	{
			this.one = "six";
			this.two = "sixty";
		}
	}
	
	private class Seven extends Number	{
		private Seven()	{
			this.one = "seven";
			this.two = "seventy";
		}
	}
	
	private class Eight extends Number	{
		private Eight()	{
			this.one = "eight";
			this.two = "eighty";
		}
	}
	
	private class Nine extends Number	{
		private Nine()	{
			this.one = "nine";
			this.two = "ninety";
		}
	}
	
	private class Zero extends Number	{
		private Zero()	{
			this.one = "";
			this.two = "";
		}
	}
	
}
