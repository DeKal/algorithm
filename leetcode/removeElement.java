// https://leetcode.com/problems/remove-element/submissions/

class removeElement {
    public int removeElement(int[] nums, int val) {

        int result = 0;
//         for (int i=0; i< nums.length; i++) {
//             if (nums[i] == val) {
//                 result++;
//                 nums[i] =-1;
//             }
//         }

//         for (int i=0; i< nums.length; i++) {
//             if (nums[i] == -1) {
//                 for (int j=i+1; j< nums.length; j++) {
//                     if (nums[j] != -1) {
//                         int temp = nums[i];
//                         nums[i] = nums[j];
//                         nums[j] = temp;
//                     }
//                 }
//             }
//         }

        for (int i=0; i< nums.length; i++) {
            if (nums[i] == val) {
                result++;
                nums[i] =-1;
            }
        }
        int j = -1;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] == -1) {
                if (j == -1) {
                    j = i+1;
                }
                while (j < nums.length && nums[j]==-1) {
                    ++j;
                }
                if (j < nums.length ) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }


        }

        return nums.length - result;
    }
}