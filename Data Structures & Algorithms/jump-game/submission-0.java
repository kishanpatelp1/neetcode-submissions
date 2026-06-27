class Solution {
    public boolean canJump(int[] nums) {
        return rec(nums, 0);
    }

    private boolean rec(int[] nums, int n) {
        int m = nums.length;
        if (n == m-1) return true;

        for (int i = 1; i <= nums[n]; i++) {
            if ((n+i) < m) {
                if (rec(nums ,n+i)) return true;
            } 
        }

        return false;
    }
}
