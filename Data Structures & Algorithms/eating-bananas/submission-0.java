class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1; 
        int right = max;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int ans = 0;
            for (int i = 0; i < piles.length; i++) {
                int pile = piles[i];
                ans += (pile + mid - 1) / mid;
            }

            if (ans > h) left = mid + 1;
            else {
                right = mid -1;
            }
        }

        return left;
    }
}
