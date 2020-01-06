class Solution {
    public int maxArea(int[] height) {
        int pointer1 = 0;
        int pointer2 = height.length - 1;
        int maxArea = 0;
        while (pointer1 != pointer2) {
            int area = this.calcArea(height, pointer1, pointer2);
            maxArea = (maxArea < area) ? area : maxArea;
            if (height[pointer1] < height[pointer2]) {
                pointer1++;
            }
            else {
                pointer2--;
            }
        }
        return maxArea;
    }
    
    private int calcArea(int[] height, int pointer1, int pointer2) {
        int minHeight = Math.min(height[pointer1], height[pointer2]);
        int width = pointer2 - pointer1;
        return minHeight * width;
    }
}