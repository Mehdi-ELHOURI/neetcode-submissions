class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, result = 0;
        var seen = new HashSet<Character>();
        while (r < n) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r++));
            result = Math.max(result, seen.size());
        }
        return result;
    }
}
