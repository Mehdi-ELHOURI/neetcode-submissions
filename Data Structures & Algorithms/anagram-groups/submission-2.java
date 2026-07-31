class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strsByFrequency = new HashMap<>();             
        for (var str : strs) {
           var frequency = new int[26];
           for (var c : str.toCharArray()) {
                frequency[c-'a']++; 
           }
            var key = Arrays.toString(frequency);
            var anagramsList = strsByFrequency.getOrDefault(key, new ArrayList());
            anagramsList.add(str);
            strsByFrequency.put(key, anagramsList);
        }
        return new ArrayList(strsByFrequency.values());
    }
}
