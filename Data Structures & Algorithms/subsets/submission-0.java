class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        rec(nums, res, 0, new ArrayList<>());
        return res;
    }

    void rec(int[] nums, List<List<Integer>> res, int index, List<Integer> list) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        rec(nums, res, index+1, list);
        list.remove(list.size()-1);
        rec(nums, res, index+1, list);
    }
}
