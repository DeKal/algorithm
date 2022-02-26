
// https://leetcode.com/problems/plus-one/submissions/
class plusOne {
    public int[] plusOne(int[] digits) {

        int firstNinePost = digits.length - 1;
        while (firstNinePost >= 0 && digits[firstNinePost] == 9) {
            firstNinePost--;
        }

        if (firstNinePost == -1) {
            int[] result = new int[digits.length + 1];
            Arrays.fill(result, 0);
            result[0] = 1;
            return result;
        }

        digits[firstNinePost]++;
        for (int i = firstNinePost+1; i < digits.length; ++i) {
            digits[i] = 0;
        }

        return digits;
    }
}