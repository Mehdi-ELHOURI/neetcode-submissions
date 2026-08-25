class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int l = 0, r = 0, n = s.length();
        Map<Character, Integer> mapS = new HashMap<>(), mapT = toOccsMap(t);
        String result = "";
        int minL = s.length() + 1;
        while (r < n) {
            addOccs(mapS, s.charAt(r), 1);
            while (containsAllWithDups(mapS, mapT)) {
                if (r - l + 1 < minL) {
                    result = s.substring(l, r + 1);
                    minL = r - l + 1;
                }
                addOccs(mapS, s.charAt(l++), -1);
            }
            r++;
        }
        return result;
    }

    private static boolean containsAllWithDups(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
        for (var e : mapT.entrySet()) {
            if (mapS.getOrDefault(e.getKey(), 0) < e.getValue())
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> toOccsMap(String str) {
        HashMap<Character, Integer> occs = new HashMap<>();
        for (var c : str.toCharArray()) {
            addOccs(occs, c, 1);
        }
        return occs;
    }

    private static void addOccs(Map<Character, Integer> occs, char c, int value) {
        occs.put(c, occs.getOrDefault(c, 0) + value);
    }
}