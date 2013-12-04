package leetcode.oj.math;

// OK
public class MultiplyTwoIntegers 
{
	// O(log(multiplier))
	public static int multiply(int multiplicand, int multiplier) 
	{
		long M1  = Math.abs((long) multiplicand);
		long M2 = Math.abs((long) multiplier);
				
		if (M1 < M2)
		{
			long T = M1;
			M1 = M2;
			M2 = T;
		}
		
		long P = 0;
		long B = M1;
		while (M2 != 0)
		{
			if ((M2 & 1) != 0)
			{
				P += B;
			}
			M2 >>= 1;
			B <<= 1;
		}
		
		return (int) (((multiplicand > 0) ^ (multiplier > 0)) ? -P : P);
	}
	
	public static void main (String[] args)
	{
		System.out.println(multiply(-2147, 1364) == -2147 * 1364);
		System.out.println(multiply(50, 7) == 50 * 7);
		System.out.println(multiply(0, -7) == 0 * -7);
		System.out.println(multiply(-150, -7) == -150 * -7);
		System.out.println(multiply(1540, 21107) == 1540 * 21107);
	}
}
