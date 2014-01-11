package leetcode.oj.todo;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache 
{
    
	private ArrayDeque<Integer> queue;
	private Map<Integer, Integer> map;
	private int m_capacity;
	
    public LRUCache(int capacity) 
    {
    	queue = new ArrayDeque<Integer>();
    	map = new HashMap<Integer, Integer>();
        m_capacity = capacity;
    }
    
    public int get(int key) 
    {
        if (map.containsKey(key))
        {
        	queue.remove(key);
        	queue.add(key);
        	return map.get(key);
        }
        else
        {
        	return -1;
        }
    }
    
    public void set(int key, int value) 
    {
        if (map.containsKey(key))
        {
        	queue.remove(key);
        	queue.add(key);
        }
        else
        {
        	if (queue.size() == m_capacity)
        	{
        		int victim = queue.remove();
        		map.remove(victim);
        	}
        	queue.add(key);
        }
        map.put(key, value);
    }

    public static void main (String[] args)
    {
    	LRUCache cache = new LRUCache(3);
    	cache.set(3, 3);
    	cache.set(4, 4);
    	cache.set(5, 5);
    	cache.set(6, 6);
    	
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));
    	System.out.println(cache.get(5));
    }
}