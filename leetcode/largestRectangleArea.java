class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int largestArea = 0;
        int col = 0;
        while (col < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[col]) {
                stack.push(col);
                ++col;
            }
            else {
                int maxCurr =  stack.pop();
                   
                int area = heights[maxCurr] * (stack.isEmpty() ? col : col - stack.peek() - 1);
                if (area > largestArea) {
                    largestArea = area;
                }
            }
        }
        
        while ( !stack.isEmpty()) {
            int maxCurr =  stack.pop();
                   
            int area = heights[maxCurr] * (stack.isEmpty() ? col : col - stack.peek() - 1);
            if (area > largestArea) {
                largestArea = area;
            }
        }
        
        return largestArea;
        
    }
}