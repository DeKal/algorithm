class Solution {
    public int trap(int[] height) {
 
        int heightIndex = getInitHeightIndex(height);
        if (heightIndex == height.length - 1)
            return 0;
        
        int trappingArea = 0;
        
        Stack<Integer> stack = new Stack<Integer>(); 
        stack.push(heightIndex);
        heightIndex++;

        while (heightIndex < height.length) {
            
          
            while (stack.size() >= 2 && height[stack.peek()] <= height[heightIndex]) {
                int middleIndex = stack.pop();
                trappingArea += calcArea(height, stack.peek(), middleIndex, heightIndex);
            }
                
            stack.push(heightIndex);
            heightIndex++;
        }
        
        return trappingArea;
    }
    
    private int getInitHeightIndex(int[] height) {
        int heightIndex = 0;
        while (heightIndex < height.length - 1 && height[heightIndex] <= height[heightIndex + 1]) {
            ++heightIndex;
        }
        System.out.println(heightIndex);
        if (heightIndex == height.length - 1)
            return height.length;
        
        return heightIndex;
    }
    
    private int calcArea(int[] height, int leftColIndex, int middleColIndex, int rightColIndex) {
        
        if (height[leftColIndex] < height[middleColIndex])
            return 0;
        
        int rectMaxHeight = Math.min(height[leftColIndex], height[rightColIndex]);
        int rectMinHeight = height[middleColIndex];
        int rectHeight = rectMaxHeight - rectMinHeight;
        int rectWidth = rightColIndex - leftColIndex - 1;
        
        return rectWidth * rectHeight;
        
    }
}