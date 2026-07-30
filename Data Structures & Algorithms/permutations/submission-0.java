class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[n];
        rec(nums, 0, res, new ArrayList<>(), vis);
        return res;
    }

    void rec(int[] nums, int index, List<List<Integer>> res, List<Integer> list, boolean[] vis) {
        if (index >= nums.length) return;
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        if(!vis[index]) {
            list.add(nums[index]);
            vis[index] = true;
            rec(nums, 0, res, list, vis);
            list.remove(list.size()-1);
            vis[index] = false;
        }

        rec(nums, index+1, res, list, vis);
    } 
}


