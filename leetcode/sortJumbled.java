
// https://leetcode.com/contest/biweekly-contest-73/problems/sort-the-jumbled-numbers/
public class sortJumbled {
    private int getMapping(int[] mapping, int a) {
        int newA = 0;
        int numberOfTens = 1;
        do {
            int digit = a%10;
            newA += mapping[digit]*numberOfTens;
            a/=10;
            numberOfTens*=10;
        }while (a!=0);

        return newA;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {

        final Integer[] sorted = new Integer[nums.length];
        for (int i =0; i<nums.length; ++i) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, new Comparator<Integer>() {
            public int compare(Integer idx1, Integer idx2) {
                int a1 = getMapping(mapping, idx1);
                int a2 = getMapping(mapping, idx2);
                return Integer.compare(a1, a2);
            }
        });


        for (int i =0; i<nums.length; ++i) {
            nums[i] = sorted[i];
        }
        return nums;
    }
}
