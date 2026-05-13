class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        rec(nums, res, new ArrayList<>(), target, n);

        return res;
    }

    private void rec(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int n) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (n <= 0 || target < 0) return;
        
        list.add(nums[n-1]);
        rec(nums, res, list, target - nums[n-1], n);
        list.remove(list.size()-1);
        rec(nums, res, list, target, n-1);
    }
}
