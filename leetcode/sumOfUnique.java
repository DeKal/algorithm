// https://leetcode.com/problems/sum-of-unique-elements/submissions/

class sumOfUnique {
    public int sumOfUnique(int[] nums) {

        int[] elementValues = new int[101];
        Arrays.fill(elementValues, 1);

        for (int i=0 ; i < nums.length; ++i) {
            elementValues[nums[i]]--;
        }
        int sum = 0;
        for (int i=0 ; i < nums.length; ++i) {
            if (elementValues[nums[i]] == 0)
                sum += nums[i];
        }
        return sum;
    }
}