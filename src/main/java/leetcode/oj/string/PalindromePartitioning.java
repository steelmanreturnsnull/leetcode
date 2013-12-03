package leetcode.oj.string;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * 
 * Return
 * 
 * [
    ["aa","b"],
    ["a","a","b"]
  ]
 *
 */

// OK
public class PalindromePartitioning 
{
	// O(N^2)
	public static boolean[][] calculateMatrix (String s)
	{
		boolean[][] matrix = new boolean[s.length()][s.length()];
	
		for (int i = 0; i < s.length(); i++)
		{
			matrix[i][i] = true;
		}
		
		for (int i = s.length() - 2; i >= 0; i--)
		{
			matrix[i][i+1] = s.charAt(i) == s.charAt(i+1);
			
			for (int j = i+2; j < s.length(); j++)
			{
				matrix[i][j] = matrix[i+1][j-1] && s.charAt(i) == s.charAt(j);
			}
		}
		
		return matrix;
	}
	
    public static ArrayList<ArrayList<String>> partition(String s) 
    {
        boolean[][] matrix = calculateMatrix(s);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>> ();
        partitionHelper(s, matrix, 0, new ArrayList<String> (), result);
        return result;
    }
    
    public static void partitionHelper(String s, boolean[][] matrix, int current, ArrayList<String> path, ArrayList<ArrayList<String>> result)
    {
    	if (current == s.length())
    	{
    		result.add(path);
    		return;
    	}
    	for (int i = current; i < s.length(); i++)
    	{
    		if (matrix[current][i])
    		{
    			ArrayList<String> newpath = new ArrayList<String> (path);
    	    	newpath.add(s.substring(current, i+1));
    			partitionHelper(s, matrix, i+1, newpath, result);
    		}
    	}
    }
    
	public static void main(String[] args) 
	{
		System.out.println(partition("google"));
	}

}
