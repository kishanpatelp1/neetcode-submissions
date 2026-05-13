class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = n - rec(intervals, 0, -1);

        return res;
    }

    private int rec(int[][] intervals,int index,int prev) {
        if (index == intervals.length) return 0;
        int skip = rec(intervals, index + 1, prev);
        int take = 0;
        if (prev == -1 || intervals[index][0] >= intervals[prev][1]) take += rec(intervals, index + 1, index) + 1;
        return Math.max(skip, take);
    }
}
