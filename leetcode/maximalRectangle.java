class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        
        int[][] heightMatrix = calcHeightMatrix(matrix);
        int maxRow = matrix.length;
        int maximalArea = 0;
        
        for (int row = 0; row < maxRow; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                System.out.print(heightMatrix[row][col] + " ");
                
            }   
            System.out.println("");
        }
        
        for (int row = 0; row < maxRow; ++row) {
            int area = calcLargestArea(heightMatrix[row]);
            if (area > maximalArea)
                maximalArea = area;
        }
        
        return maximalArea;    
    }
    
    private int[][] calcHeightMatrix(char[][] matrix) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        
        int[][] resultMatrix = new int[maxRow][maxCol];

        for (int col = 0; col < maxCol; ++col) {
            for (int row = 0; row < maxRow; ++ row) {
                if (row > 0 && matrix[row][col] == '1') {
                    resultMatrix[row][col] =  resultMatrix[row - 1][col] + (matrix[row][col] - '0');
                }
                else {
                    resultMatrix[row][col] =  matrix[row][col] - '0';
                }
            }
        }
        return resultMatrix;
    } 
    
    public int calcLargestArea(int[] heights) {
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