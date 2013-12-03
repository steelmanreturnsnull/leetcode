package leetcode.oj.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * Note:
 * 
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */

// OK
public class ValidPalindrome 
{
	// O(N)
    public static boolean isPalindrome(String s) 
    {
        int i = 0;
        int j = s.length() - 1;
        while (i < j)
        {
        	if (!Character.isLetterOrDigit(s.charAt(i)))
        	{
        		i++;
        		continue;
        	}
        	if (!Character.isLetterOrDigit(s.charAt(j)))
        	{
        		j--;
        		continue;
        	}
        	if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
        		return false;
        }
        return true;
    }
    // Mistakes:
    // 1. Read the problem: "alphanumeric"
    // 2. increment/decrement indices when match
    
    public static void main (String[] args)
    {
    	System.out.println(isPalindrome("-a."));
    	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    	System.out.println(isPalindrome("race a car"));
    }
}
