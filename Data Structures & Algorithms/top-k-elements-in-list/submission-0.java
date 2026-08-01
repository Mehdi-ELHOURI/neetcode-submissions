class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .entrySet().stream()
        .sorted(Comparator.comparing(e -> -e.getValue()))
        .limit(k)
        .map(e -> e.getKey())
        .collect(Collectors.toList())
        .stream().mapToInt(Integer::intValue).toArray();
    }
}
