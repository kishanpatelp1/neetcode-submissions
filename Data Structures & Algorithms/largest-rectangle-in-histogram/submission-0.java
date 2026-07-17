class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            for (int j = i; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    left = j;
                } else {
                    break;
                }
            }

            for (int j = i+1; j < n; j++) {
                if (heights[j] >= heights[i]) {
                    right = j;
                } else {
                    break;
                }
            }

            int area = (right - left + 1) * heights[i];
            max = Math.max(max, area);
        }

        return max;
    }
}
