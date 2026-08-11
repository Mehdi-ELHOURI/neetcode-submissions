class Solution {
    public boolean isPalindrome(String s) {
        var chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            if (!isAlphanumeric(chars[i])) {
                i++;
                continue;
            }
            if (!isAlphanumeric(chars[j])) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return  (64 < c && c < 91) || (96 < c && c < 123) || (47 < c && c < 58);
    }
}
