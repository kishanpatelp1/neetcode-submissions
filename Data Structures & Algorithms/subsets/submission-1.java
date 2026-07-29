class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        rec(nums, res, 0, new ArrayList<>());
        return res;
    }

    void rec(int[] nums, List<List<Integer>> res, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            rec(nums, res, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
