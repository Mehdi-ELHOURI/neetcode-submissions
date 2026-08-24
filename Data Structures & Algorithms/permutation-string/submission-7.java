class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] occsS1 = new int[26], occsS2 = new int[26];
        for (var c : s1.toCharArray()) occsS1[c - 'a']++;
        int k = s1.length(), n = s2.length(), l = 0, r = 0;
        while (r < n) {
            if (r - l + 1 > k) occsS2[s2.charAt(l++) - 'a']--;
            occsS2[s2.charAt(r++) - 'a']++;
            if (Arrays.equals(occsS1, occsS2)) return true;
        }
        return false;
    }
}
