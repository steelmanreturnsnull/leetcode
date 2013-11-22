package leetcode.oj.matrix;

import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * 
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 */

// OK
public class SpiralMatrix 
{
	// O(mn)
	public static ArrayList<Integer> spiralOrder(int[][] matrix) 
	{
		ArrayList<Integer> result = new ArrayList<Integer> ();
		
        int rows = matrix.length - 1;
        if (rows < 0)
        	return result;
        int cols = matrix[0].length;
        
        int r = 0, c = -1;
        
        while (true)
        {
        	if (cols == 0)
        		return result;
        	for (int i = 1; i <= cols; i++)
        	{
        		result.add(matrix[r][++c]);
        	}
        	cols--;
        	
        	if (rows == 0)
        		return result;
        	for (int i = 1; i <= rows; i++)
        	{
        		result.add(matrix[++r][c]);
        	}
        	rows--;
        	
        	if (cols == 0)
        		return result;
        	for (int i = 1; i <= cols; i++)
        	{
        		result.add(matrix[r][--c]);
        	}
        	cols--;
        	
        	if (rows == 0)
        		return result;
        	for (int i = 1; i <= rows; i++)
        	{
        		result.add(matrix[--r][c]);
        	}
        	rows--;
        }
    }
	// Mistake:
	// 1. need to consider empty matrix
	// Other thoughts:
	// Use recursion

	public static void main(String[] args) 
	{
		int[][] matrix = new int[][]
				{
					{1,2,3,4,5},
					{6,7,8,9,10},
					{11,12,13,14,15}
				};
		System.out.println(spiralOrder(matrix));
	}
}
