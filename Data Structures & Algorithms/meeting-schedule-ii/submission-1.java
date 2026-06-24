/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Integer> q = new PriorityQueue<>();

        for(Interval interval : intervals) {
            if (!q.isEmpty() && q.peek() <= interval.start) {
                q.poll();
                q.add(interval.end);
            }
            else {
                q.add(interval.end);
            }
        }

        return q.size();
    }
}
