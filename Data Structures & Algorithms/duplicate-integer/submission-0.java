class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNums = Arrays.stream(nums)
                                        .boxed()
                                        .collect(Collectors.toSet());        
        return nums.length != uniqueNums.size();
    }
}