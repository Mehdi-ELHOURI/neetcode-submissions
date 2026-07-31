class Solution {
    public boolean isAnagram(String s, String t) {
        return s.length() == t.length() &&
        countChars(s).equals(countChars(t));
    }

    private HashMap<Character,Integer> countChars(String s) {
        var charCount = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }
}
