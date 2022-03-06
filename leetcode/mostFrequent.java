// https://leetcode.com/contest/biweekly-contest-73/problems/most-frequent-number-following-key-in-an-array/
public class mostFrequent {
    public int mostFrequent(int[] nums, int key) {
        Set<Integer> set = new HashSet<>();
        for (int j=0; j<nums.length; ++j) {
            set.add(nums[j]);
        }

        int ans = 0;
        int max = 0;
        for(Integer num : set){
            int occurrences = 0;
            for (int i=1; i < nums.length; ++i) {
                if (num == nums[i] && nums[i-1] == key) {
                    occurrences++;
                }
            }
            if (max < occurrences) {
                max = occurrences;
                ans = num;
            }
        }

        return ans;

    }
}
