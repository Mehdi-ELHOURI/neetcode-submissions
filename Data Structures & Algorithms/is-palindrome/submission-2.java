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
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
        }
}
