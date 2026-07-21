class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        rec(nums, target, 0, new ArrayList<>());
        return res;
    }

    void rec(int[] nums, int target, int index, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index >= nums.length || target < 0) return;
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            rec(nums, target-nums[i], i, path);
            path.remove(path.size()-1);
        }
    }
}