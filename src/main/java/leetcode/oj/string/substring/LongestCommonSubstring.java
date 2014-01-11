package leetcode.oj.string.substring;

public class LongestCommonSubstring 
{
	// O(M*N), O(M*N) space
	public static String commonSubstring (String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();
		
		int max = 0;
		int max_i = 0, max_j = 0;
		
		int[][] array = new int[m+1][n+1];
		for (int i = 0; i <= m; i++) // not necessary because it's java
		{
			array[i][0] = 0;
		}
		
		for (int j = 0; j <= n; j++)
		{
			array[0][j] = 0;
		}
		
		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (s1.charAt(i-1) == s2.charAt(j-1))
				{
					array[i][j] = array[i-1][j-1] + 1;
					if (array[i][j] > max)
					{
						max = array[i][j];
						max_i = i;
						max_j = j;
					}
				}
				else
				{
					array[i][j] = 0;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = max_i, j = max_j; array[i][j] > 0; i--, j--)
		{
			sb.append(s1.charAt(i-1));
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(commonSubstring("ABAZDC", "BACBAD"));
		System.out.println(commonSubstring("ZIP", "ZAP"));
		System.out.println(commonSubstring("DATANA", "BANANA"));
		System.out.println(commonSubstring("Hi peter go swimming?", "I'm peter go"));
	}
}
