class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[n+1];

        for (int key : freq.keySet()) {
            if (bucket[freq.get(key)] == null) bucket[freq.get(key)] = new ArrayList<>();
            bucket[freq.get(key)].add(key);
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >=0; i--) {
            if (bucket[i] == null) continue;

            for (int num : bucket[i]) {
                res[index] = num;
                index++;
                if (index == k) break;
            }

            if (index == k) break;
        }

        return res;
    }
}
