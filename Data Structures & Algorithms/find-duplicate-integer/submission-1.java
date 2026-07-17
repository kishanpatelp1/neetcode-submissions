class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        fast = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
