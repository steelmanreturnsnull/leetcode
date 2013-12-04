package leetcode.oj.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * 
 * return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * 
 * Given s = "Hello World",
 * 
 * return 5.
 *
 */

// OK
public class LengthOfLastWord 
{
	// O(N)
	public static int lengthOfLastWord(String s) 
	{
		String[] ss = s.split(" ");
		for (int i = ss.length-1; i >= 0; i--)
		{
			if (ss[i].length() > 0)
				return ss[i].length();
		}
        return 0;
    }
	
	public static void main (String[] args)
	{
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" tchy "));
		System.out.println(lengthOfLastWord("   "));
	}
}
