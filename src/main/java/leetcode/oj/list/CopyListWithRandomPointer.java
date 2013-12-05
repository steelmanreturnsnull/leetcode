package leetcode.oj.list;

import java.util.HashMap;
import java.util.Map;

import leetcode.oj.common.model.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */

// OK
public class CopyListWithRandomPointer 
{
	// O(N)
	public RandomListNode copyRandomList(RandomListNode head) 
	{
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode> ();
		
		RandomListNode iter = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode prev = dummy;
		
		
		while (iter != null)
		{
			RandomListNode current = new RandomListNode(iter.label);
			prev.next = current;
			map.put(iter, current);
			iter = iter.next;
			prev = current;
		}
		
		iter = head;
		RandomListNode iter2 = dummy.next;
		while (iter != null)
		{
			iter2.random = map.get(iter.random);
			iter = iter.next;
			iter2 = iter2.next;
		}
		return dummy.next;
    }
	
	public RandomListNode copyRandomList2(RandomListNode head) 
	{
		// insert nodes
		RandomListNode iter = head;
		while (iter != null)
		{
			RandomListNode current = new RandomListNode(iter.label);
			current.next = iter.next;
			iter.next = current;
			iter = current.next;
		}
		
		// copy random pointers
		iter = head;
		while (iter != null)
		{
			RandomListNode current = iter.next;
			if (iter.random != null)
				current.random = iter.random.next;
			iter = current.next;
		}
		
		// decouple two lists
		iter = head;
		RandomListNode ret = (head == null) ? null : head.next;
		while (iter != null)
		{
			RandomListNode next = iter.next;
			if (next != null)
				iter.next = next.next;
			iter = next;
		}
		return ret;
    }
}
