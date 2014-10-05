import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/merge-intervals/}
 * [Tag]        - $range$
 */
public class merge_intervals
{
    public class Interval
    {
        int start;
        int end;

        Interval()
        {
            start = 0;
            end = 0;
        }

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();

        if (n == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

        result.add(new Interval(intervals.get(0).start, intervals.get(0).end));
        for (int i = 0; i < n - 1; ++i) {
            Interval a = result.get(result.size() - 1), b = intervals.get(i + 1);

            if (a.end < b.start) {
                result.add(b);
            } else if (a.end >= b.start) {
                a.end = Math.max(a.end, b.end);
            }
        }

        return result;
    }
}
