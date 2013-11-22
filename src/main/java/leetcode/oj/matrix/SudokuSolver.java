package leetcode.oj.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 */

// OK
public class SudokuSolver 
{
	// O(N^2 !)
	public static void solveSudoku(char[][] board) 
	{
		ArrayList<Set<Integer>> vSets = new ArrayList<Set<Integer>>();
		ArrayList<Set<Integer>> hSets = new ArrayList<Set<Integer>>();
		ArrayList<Set<Integer>> sSets = new ArrayList<Set<Integer>>();
		ArrayList<ArrayList<Integer>> unfilled = new ArrayList<ArrayList<Integer>>();
		
		// Initialize arrays
		for (int row = 0; row < board.length; row++)
		{
			Set<Integer> vSet = new HashSet<Integer>();
			vSets.add(vSet);
			
			Set<Integer> hSet = new HashSet<Integer>();
			hSets.add(hSet);
			
			Set<Integer> sSet = new HashSet<Integer>();
			sSets.add(sSet);
		}
			
		// Pre-process board
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				char current = board[row][col];
				if (current == '.')
				{
					ArrayList<Integer> index = new ArrayList<Integer>();
					index.add(row);
					index.add(col);
					index.add(0);
					unfilled.add(index);
				}
				else
				{
					Set<Integer> hSet = hSets.get(row);
					hSet.add(Integer.parseInt(String.valueOf(current)));
					
					Set<Integer> vSet = vSets.get(col);
					vSet.add(Integer.parseInt(String.valueOf(current)));
					
					int s_id = row / 3 * 3 + col / 3;
					Set<Integer> sSet = sSets.get(s_id);
					sSet.add(Integer.parseInt(String.valueOf(current)));
				}
			}
		}
		
		// fill in numbers
		int i = 0;
		while (i <unfilled.size())
		{
			ArrayList<Integer> current = unfilled.get(i);
			int row = current.get(0);
			int col = current.get(1);
			int s_id = row / 3 * 3 + col / 3;
			boolean success = false;
			int prev = current.get(2);
			int num;
			for (num = prev + 1; num <= 9; num++)
			{
				if (hSets.get(row).contains(num))
					continue;
				if (vSets.get(col).contains(num))
					continue;
				if (sSets.get(s_id).contains(num))
					continue;
				
				success = true;
				break;
			}
			
			if (success)
			{
				i++;
				current.set(2, num);
				hSets.get(row).add(num);
				vSets.get(col).add(num);
				sSets.get(s_id).add(num);
			}
			else
			{
				i--;
				current.set(2, 0);
			}

			hSets.get(row).remove(prev);
			vSets.get(col).remove(prev);
			sSets.get(s_id).remove(prev);
		}
		
		// output result
		for (ArrayList<Integer> current : unfilled)
		{
			int row = current.get(0);
			int col = current.get(1);
			int num = current.get(2);
			board[row][col] = String.valueOf(num).toCharArray()[0];
		}
    }
	
	// Mistakes: 
	// 1.Need to check with previously filled in spots
	// 2.Need to remove prev from sets
	
	public static void main(String[] args)
	{
		char[][] board = new char[][] 
			{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
			};
		solveSudoku(board);
	}
}
