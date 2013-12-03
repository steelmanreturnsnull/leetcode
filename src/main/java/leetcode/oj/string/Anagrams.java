package leetcode.oj.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case
 */

// OK
public class Anagrams 
{
	// O(N)
	public static ArrayList<String> anagrams(String[] strs) 
	{
		ArrayList<String> result = new ArrayList<String> ();
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for (String s : strs)
		{
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = String.valueOf(c);
			
			if (map.containsKey(sorted))
			{
				map.get(sorted).add(s);
			}
			else
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(sorted, list);
			}

		}
		
		for (Entry<String, ArrayList<String>> e : map.entrySet())
		{
			ArrayList<String> list = (ArrayList<String>) e.getValue();
			if (list.size() > 1)
				result.addAll(list);
		}
		return result;
    }
	// Mistakes:
	// 1. char[] -> String, c.toString is wrong!!!
	// 2. need to output all groups

	public static void main (String[] args)
	{
		String[] s1 = {"", ""};
		System.out.println(anagrams(s1));
	}

}
