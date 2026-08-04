class Solution {
    public String encode(List<String> strs) {
        String delimiter = ";";
        StringBuilder encoded = new StringBuilder();
        for (var str : strs) {
            encoded.append(str.length()).append(delimiter).append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        char delimiter = ';';
        String nextStrLen = "";
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (delimiter == c) {
                int nextLen = Integer.parseInt(nextStrLen);
                String nextStr = str.substring(i + 1, i + 1 + nextLen);
                res.add(nextStr);
                nextStrLen = "";
                i += nextLen;
            } else {
                nextStrLen += c;
            }
        }
        return res;
    }
}
