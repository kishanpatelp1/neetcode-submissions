class Solution { 
    public List<List<Integer>> subsetsWithDup(int[] nums) { 
        List<List<Integer>> res = new ArrayList<>(); 
        Arrays.sort(nums); 
        rec(nums, res, 0, new ArrayList<>()); 
        return res; 
    } 

    void rec(int[] nums, List<List<Integer>> res, int index, List<Integer> list) { 
        res.add(new ArrayList<>(list)); 
        
        for (int i = index; i < nums.length; i++) { 
            if (i > index && nums[i] == nums[i-1]) {
                continue; 
            }
            
            list.add(nums[i]); 
            rec(nums, res, i + 1, list); 
            list.remove(list.size() - 1); 
        } 
    } 
}
