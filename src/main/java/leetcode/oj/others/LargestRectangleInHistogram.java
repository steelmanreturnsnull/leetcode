package leetcode.oj.others;

public class LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] height) {

		int max = 0; 
		for (int i = 0; i < height.length; i++)
		{
			if ((height.length - i) * height[i] <= max)
				continue;
			int j;
			for (j = i+1; j < height.length; j++)
			{
				if (height[j] < height[i])
				{
					if (height[i] * (j-i) > max)
						max = height[i] * (j-i);
					break;
				}
			}
			
			if (j == height.length)
			{
				if (height[i] * (j-i) > max)
					max = height[i] * (j-i);
			}
		}
		return max;
	}
	
	public static void main (String[] args)
	{
		int[] height = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		largestRectangleArea(height);
	}

}
