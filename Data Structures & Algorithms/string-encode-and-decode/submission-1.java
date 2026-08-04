class Solution {

    public String encode(List<String> strs) {
        String delimiter = ";";
        String encoded = "";
        for (var str : strs) {
            encoded += str.length() + delimiter + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        char delimiter = ';';
        String nextStrLen = "";
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (delimiter == c) {
                int nextLen = Integer.parseInt(nextStrLen);
                String nextStr = "";
                for (int j = 1; j <= nextLen; j++)  {
                    nextStr += str.charAt(i+j);
                }
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
