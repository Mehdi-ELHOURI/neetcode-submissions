class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int result = 0;
        for (int i = 0; i < n ; i++) {
            var seen = new HashSet<Character>();
            for (int j = i ; j < n && !seen.contains(s.charAt(j)); j++) {
                seen.add(s.charAt(j));
            }
            result = Math.max(seen.size(), result);
        }
        return result;
    }
}
