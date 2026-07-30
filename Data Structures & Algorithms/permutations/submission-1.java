class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res =  new ArrayList<>();
        boolean[] vis = new boolean[n];
        rec(nums, res, new ArrayList<>(), 0, vis);
        return res;
    }

    void rec(int[] nums, List<List<Integer>> res, List<Integer> list, int index, boolean[] vis) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            list.add(nums[i]);
            vis[i] = true;
            rec(nums, res, list, i+1, vis);
            list.remove(list.size()-1);
            vis[i] = false;
        }
    }
}
