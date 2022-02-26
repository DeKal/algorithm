
// https://leetcode.com/problems/candy/submissions/
class Candy {
    public int candy(int[] ratings) {
        int[] left=new int[ratings.length];

        // [1,2,87,87,87,2,1]
        // 1 2 3 1 3 2 1
        Arrays.fill(left, 1);
        for (int i=0; i < ratings.length-1; ++i) {
            if (ratings[i] < ratings[i+1]) {
                left[i+1] = left[i] + 1;
            }
        }

        int[] right=new int[ratings.length];
        Arrays.fill(right, 1);
        for (int i=ratings.length-1; i>0; --i) {
            if (ratings[i] < ratings[i-1]) {
                right[i-1] = right[i] + 1;
            }
        }

        int ans = 0;
        for (int i=0; i < ratings.length; ++i) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}