class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int l = 0, r = 0, n = s.length();
        Map<Character, Integer> mapS = new HashMap<>(), mapT = toOccsMap(t);
        int need = mapT.keySet().size(), have = 0;
        int[] res = new int[2];
        int minL = Integer.MAX_VALUE;
        while (r < n) {
            char c = s.charAt(r);
            if (mapT.containsKey(c)) {
                addOccs(mapS, c, 1);
                if (mapS.get(c).equals(mapT.get(c))) {
                    have++;
                }
            }
            while (have == need) {
                if (r - l + 1 < minL) {
                    res[0] = l;
                    res[1] = r + 1;
                    minL = r - l + 1;
                }
                if (mapT.containsKey(s.charAt(l))) {
                    if (mapS.get(s.charAt(l)).equals(mapT.get(s.charAt(l)))) {
                        have--;
                    }
                    addOccs(mapS, s.charAt(l), -1);
                }
                l++;
            }
            r++;
        }
        return minL < Integer.MAX_VALUE ? s.substring(res[0], res[1]) : "";
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