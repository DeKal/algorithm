
// https://leetcode.com/problems/merge-sorted-array/submissions/
class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int q = m-1;
        int w = n-1;
        for (int i = nums1.length-1; i>=0 && q>=0 && w>=0; --i) {

            if (nums1[q] < nums2[w]) {
                nums1[i] = nums2[w];
                w--;
            } else if (nums1[q] >= nums2[w])  {
                nums1[i] = nums1[q];
                q--;
            }
        }

        if (q>=0) {
            for (int i = q; i>=0; --i) {
                nums1[i] = nums1[q];
                q--;
            }
        } else if (w >= 0) {
            for (int i = w; i>=0; --i) {
                nums1[i] = nums2[w];
                w--;
            }
        }



    }
}