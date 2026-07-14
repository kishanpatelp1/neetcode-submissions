class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int index = 0;
        for (int i = 0; i <= n-k; i++) {
            int max = nums[i];
            for (int j = i+1; j < i+k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[index++] = max;
        }

        return res;
    }
}
