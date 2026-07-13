class Solution { 
    public String minWindow(String s, String t) { 
        int n = s.length(); 
        int m = t.length(); 
        int need[] = new int[128]; 
        int window[] = new int[128]; 
        int required = 0; 
        
        for (int i = 0; i < m; i++) { 
            if(need[t.charAt(i)] == 0) required++; 
            need[t.charAt(i)]++; 
        } 
        
        int min = Integer.MAX_VALUE; 
        int current = 0; 
        int l = 0; 
        int start = -1; 
        
        for (int r = 0; r < n; r++) { 
            window[s.charAt(r)]++; 
            if (need[s.charAt(r)] == window[s.charAt(r)]) current++; 
            
            while (current == required) { 
                if (min > r-l+1) { 
                    min = r-l+1; 
                    start = l; 
                } 
                
                window[s.charAt(l)]--; 
                
                if (window[s.charAt(l)] < need[s.charAt(l)]) current--; 
                l++; 
            } 
        } 
        return (start == -1) ? "" : s.substring(start, start + min); 
    } 
}
