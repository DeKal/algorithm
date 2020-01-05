boolean containsCloseNums(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i=0; i<nums.length; ++i){
        if (map.containsKey(nums[i])){
            if (k>= Math.abs(map.get(nums[i]) - i) )
                return true;
        }
        map.put(nums[i], i);
    }
    return false;
}