class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (m < n) return false;

        int need[] = new int[26];
        int window[] = new int[26];

        for (int i = 0; i < n; i++) {
            need[s1.charAt(i)-'a']++;
        }

        for (int r = 0; r < n; r++) {
            window[s2.charAt(r)-'a']++;
        }

        if (equals(need, window)) return true;

        for (int r = n; r < m; r++) {
            window[s2.charAt(r)-'a']++;
            window[s2.charAt((r-n))-'a']--;
            if (equals(need, window)) return true;
        }

        return false;
    }

    boolean equals (int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }

        return true;
    }
}
