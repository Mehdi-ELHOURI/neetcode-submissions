class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length(), n = s2.length();
        int[] occs = new int[26];
        for(var c : s1.toCharArray()) {
            occs[c - 'a']++;
        }
        for(int i = 0; i <= n-k; i++) {
            int[] copy = occs.clone();
            for (int j = i; j < i + k; j++) {
                copy[s2.charAt(j) - 'a']--;
            }
            boolean match = true;
            for (var num : copy) {
                if (num != 0) { match = false; break; }
            }
            if (match) return true;
        }
        return false;
    }
}