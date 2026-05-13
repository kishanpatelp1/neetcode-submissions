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
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int days = 0;
        int max = 0;

        int first = 0;
        int finish = 0;

        while (first < n) {
            if (start[first] < end[finish]) {
                days++;
                first++;
            } 
            else {
                finish++;
                days--;
            }
            max = Math.max(max, days);
        }

        return max;       
    }
}