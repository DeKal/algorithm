class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder resultBuilder = new StringBuilder();
        int minLength = this.findMinLength(strs);
        
        for (int pos = 0; pos < minLength; ++pos){
            Character currentChar = strs[0].charAt(pos); 
            for (int strNo = 1; strNo < strs.length; ++strNo) {
                if (strs[strNo].charAt(pos) != currentChar) {
                    return resultBuilder.toString();
                }
            }    
            resultBuilder.append(currentChar);
        }
        return resultBuilder.toString();
        
    }
    
    private int findMinLength(String[] strs) {
        if (strs.length == 0) return 0;
    
        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());   
        }
        return minLength;
    }
}