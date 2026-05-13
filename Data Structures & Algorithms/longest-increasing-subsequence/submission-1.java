class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(dp, nums, 0, -1);
    }

    int rec(int[][] dp, int[] nums, int n, int prev) {
        if (n == nums.length)
            return 0;

        if (dp[n][prev + 1] != -1)
            return dp[n][prev + 1];

        int notTake = rec(dp, nums, n + 1, prev);
        int take = 0;

        if (prev == -1 || nums[prev] < nums[n])
            take = 1 + rec(dp, nums, n + 1, n);

        return dp[n][prev + 1] = Math.max(notTake, take);
    }
}
