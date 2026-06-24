class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int cnt = 0;
        if (n <= 1) return cnt;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prev) {
                cnt++;
                prev = Math.min(prev, intervals[i][1]);
            }
            else prev = intervals[i][1];
        }

        return cnt;
    }
}
