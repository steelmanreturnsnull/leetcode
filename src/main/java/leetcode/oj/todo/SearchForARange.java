package leetcode.oj.todo;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * 
 * return [3, 4].
 *
 */
public class SearchForARange 
{
	// TODO
	public int[] searchRange(int[] A, int target) 
	{
		return searchRange(A, target, 0, A.length-1);
    }
	
	public int[] searchRange(int[] A, int target, int L, int R)
	{
		if (L > R)
			return new int[]{-1, -1};
		int M = L + (R - L) / 2;
		if (A[M] == target)
			return searchRange(A, L, R);
		else if (A[M] < target)
			return searchRange(A, target, M+1, R);
		else
			return searchRange(A, target, L, M-1);
	}
	
	public int[] searchRange(int[] A, int L, int R)
	{
		//int M = L + (R - L) / 2;
		return null;
	}
}
