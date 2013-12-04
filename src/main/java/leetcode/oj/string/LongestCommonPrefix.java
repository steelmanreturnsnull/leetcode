package leetcode.oj.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */

// OK
public class LongestCommonPrefix 
{
	// O(m*N)
	public static String longestCommonPrefix(String[] strs) 
	{
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		int current = 0;
		while (current < strs[0].length())
		{
			char c = strs[0].charAt(current);
			for (int i = 1; i < strs.length; i++)
			{
				if (current >= strs[i].length() || strs[i].charAt(current) != c)
					return strs[0].substring(0, current);
			}
			current++;
		}
		return strs[0].substring(0, current);
	}
	// Mistakes:
	// 1. need to return at the last statement
	
	public static void main (String[] args)
	{
		String[] ss = {"abab","aba","abc"};
		System.out.println(longestCommonPrefix(ss));
	}
}
