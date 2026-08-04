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
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            int delimiterIndex = str.indexOf(delimiter, i);
            int nextLen = Integer.parseInt(str.substring(i, delimiterIndex));
            String nextStr = str.substring(delimiterIndex + 1, delimiterIndex + 1 + nextLen);
            res.add(nextStr);
            i = delimiterIndex + 1 + nextLen;
        }
        return res;
    }
}
