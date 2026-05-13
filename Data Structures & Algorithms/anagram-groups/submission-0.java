class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s : strs){
            int[] arr = new int[26];
            for(char ch : s.toCharArray()){
                arr[ch - 'a']++;
            }
            String key = Arrays.toString(arr);
            if(!res.containsKey(key)) res.put(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
