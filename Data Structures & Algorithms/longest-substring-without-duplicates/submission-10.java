class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, result = 0;
        var uniqueChars = new HashSet<Character>();
        while (r < n) {
            if (!uniqueChars.contains(s.charAt(r))) {
                uniqueChars.add(s.charAt(r));
                result = Math.max(result, uniqueChars.size());
                r++;
            } else {
                uniqueChars = new HashSet();
                r = ++l;
            }
        }
        return result;
    }
}
