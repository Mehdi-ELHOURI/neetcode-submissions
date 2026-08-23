class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), result = 0, l = 0, r = 0, maxF = 0;
        int[] occs = new int[26];
        while (r < n) {
            maxF = Math.max(++occs[s.charAt(r) - 'A'], maxF);
            while (r - l + 1 - maxF > k) {
                --occs[s.charAt(l++) - 'A'];
            }
            result = Math.max(result, r++ - l + 1);
        }
        return result;
    }
}