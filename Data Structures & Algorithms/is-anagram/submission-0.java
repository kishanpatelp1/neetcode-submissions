class Solution {
    public boolean isAnagram(String s, String t) {
        char[] hm1 = new char[26];
        char[] hm2 = new char[26];
        for(char ch : s.toCharArray()){
            hm1[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            hm2[ch - 'a']++;
        }
        for(int i = 0; i < hm1.length; i++){
            if(hm1[i] != hm2[i]) return false;
        }
        return true;
    }
}
