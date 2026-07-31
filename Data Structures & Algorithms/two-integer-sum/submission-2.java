class Solution {
    public int[] twoSum(int[] nums, int target) {
        var result = new int[2];
        var numToIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndexMap.containsKey(target-nums[i])) {
                result[0] = numToIndexMap.get(target-nums[i]);
                result[1] = i;
                break;
            }
            numToIndexMap.put(nums[i], i);
        }
        return result;
    }
}
