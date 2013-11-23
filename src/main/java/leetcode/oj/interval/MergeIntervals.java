package leetcode.oj.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import leetcode.oj.common.model.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 *
 */

// OK
public class MergeIntervals 
{
	public static Comparator<Interval> intervalComparator = new Comparator<Interval>()
	{
		@Override
		public int compare(Interval o1, Interval o2) 
		{
			return o1.start - o2.start;
		}
	};
	
	// O(NlogN)
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) 
	{
		Collections.sort(intervals, intervalComparator);
		ArrayList<Interval> result = new ArrayList<Interval> ();
		Interval current;
		Interval prev = null;
		for (int i = 0; i < intervals.size(); i++)
		{
			current = intervals.get(i);
			if (prev != null)
			{
				if (prev.end < current.start)
				{
					result.add(prev);
				}
				else
				{
					current.start = prev.start;
					current.end = Math.max(prev.end, current.end);
				}
			}
			
			prev = current;
			
			if (i == intervals.size() -1)
			{
				result.add(prev);
			}
		}
		return result;
    }
}
