package leetcode.oj.common.model;

/**
 * Definition for singly-linked list with a random pointer.
 * 
 */

// OK
public class RandomListNode 
{
	public int label;
	public RandomListNode next, random;
	
	public RandomListNode(int x) 
	{ 
		this.label = x; 
	}
}