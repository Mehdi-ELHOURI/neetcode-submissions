class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strsBySortedAnagram = new HashMap<>();     
        for (var str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            var sortedStr= new String(chars);
            var anagramsList = strsBySortedAnagram.getOrDefault(sortedStr, new ArrayList());
            anagramsList.add(str);
            strsBySortedAnagram.put(sortedStr, anagramsList);
        }
        return new ArrayList(strsBySortedAnagram.values());
    }
}
