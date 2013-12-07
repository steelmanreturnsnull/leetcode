package leetcode.oj.string.substring;

// OK
public class LongestCommonSequence 
{
	// O(M*N), O(M*N) space
	public static String commonSequence (String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();
		
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
				}
				else
				{
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = m, j = n; i >= 1 && j >= 1;)
		{
			if (array[i][j] == array[i-1][j])
				i--;
			else if (array[i][j] == array[i][j-1])
				j--;
			else
			{
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(commonSequence("ABAZDC", "BACBAD"));
		System.out.println(commonSequence("ZIP", "ZAP"));
		System.out.println(commonSequence("DATANA", "BANANA"));
	}
}
