class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > st.peek()[0]) {
                int ans = i - st.peek()[1];
                res[st.peek()[1]] = ans;
                st.pop();
            } 
            st.push(new int[]{temperatures[i], i});
        }
    
        return res;
    }
}
