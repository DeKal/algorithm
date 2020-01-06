class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
    
        Map<Integer, Integer> numPosMap = new HashMap<>();
        
        for (int numIndex=0; numIndex < nums.length; ++numIndex) {
            Integer firstPart = nums[numIndex];
            Integer secondPart = target - firstPart;
            
            if (numPosMap.containsKey(secondPart)) {
                result[0] = numPosMap.get(secondPart);
                result[1] = numIndex;
                break;
            } 
            numPosMap.put(firstPart, numIndex);
        }
        return result;
    }
}
    