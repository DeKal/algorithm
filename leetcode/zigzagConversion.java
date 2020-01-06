class Solution {
    public String convert(String s, int numRows) {
        StringBuilder resultBuilder = new StringBuilder();
        Set<Integer> isJumpSet = new HashSet<>(); 
        int bigJump = (numRows - 1) * 2;
        if (bigJump == 0) 
            return s;
        for (int curDepth = 1; curDepth <= numRows; ++curDepth) {
            int smalljump = (numRows - curDepth) * 2;
            int runningIndex = curDepth - 1;
            while (runningIndex < s.length()) {
                if (!isJumpSet.contains(runningIndex)) {
                    isJumpSet.add(runningIndex);
                    resultBuilder.append(s.charAt(runningIndex));
                }
                
                int smalljumpIndex = runningIndex + smalljump;
                if (smalljumpIndex < s.length() && !isJumpSet.contains(smalljumpIndex)) {
                    isJumpSet.add(smalljumpIndex);
                    resultBuilder.append(s.charAt(smalljumpIndex));
                }
                runningIndex += bigJump;
            }
        }
        return resultBuilder.toString();
    }
}