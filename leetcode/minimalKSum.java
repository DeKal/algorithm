// https://leetcode.com/contest/weekly-contest-283/problems/append-k-integers-with-minimal-sum/
public class minimalKSum {

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        if (k < nums[0]) {
            long left = k;
            return left*(left+1)/2;
        }

        long ans = 0;
        int kk = 0;
        for (int i=0; i<nums.length && kk<k; ++i) {
            long firstNum = i>0 ? nums[i-1] : 0;
            long increase = Math.max(Math.min(nums[i] - firstNum - 1, k - kk), 0);
            long secondNum = firstNum + increase;

            kk += increase;
            ans += secondNum*(secondNum+1)/2 - firstNum*(firstNum+1)/2;
        }


        if (kk < k) {
            int left = k - kk;
            long firstNum = nums[nums.length-1];
            long secondNum = nums[nums.length-1] + left;
            ans += secondNum*(secondNum+1)/2 - firstNum*(firstNum+1)/2;
        }
        return ans;
    }
}
