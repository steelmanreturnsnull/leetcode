package leetcode.oj.math;

/**
 * Divide two integers without using multiplication, division and mod operator.
 */

// OK
public class DivideTwoIntegers 
{
	// O(log(dividend))
	public static int divide(int dividend, int divisor) 
	{
		long N = Math.abs((long) dividend);
		long D = Math.abs((long) divisor);
				
		long R = D;
		int i = 0;
		while (R << 1 <= N)
		{
			R = R << 1;
			i++;
		}
		
		long Q = 0;
		while (i >= 0)
		{
			if (N >= R)
			{
				N = N - R;
				Q += 1 << i;
			}
			R = R >> 1;
			i --;
		}
		
		return (int) (((dividend > 0) ^ (divisor > 0)) ? -Q : Q);
	}
	// Idea:
	// Q = 5 represented in binary : 101, calculate each bit
	// similar to long division binary version
	// Mistakes:
	// 1. Consider overflow!
	
	public static void main (String[] args)
	{
		System.out.println(divide(-2147483648, 1));
		System.out.println(divide(50, 7));
	}
}
