class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> posMap = new HashMap<>();
        int maxLength = 0;
        int currentLength = 0;
        int start = 0;
        int sIndex = 0;
        while (sIndex < s.length()) {
            Character curChar = s.charAt(sIndex);
            if (!posMap.containsKey(curChar)) {
                currentLength++;   
            } else {
                maxLength = (maxLength < currentLength) ? currentLength : maxLength;
                int newIndex = posMap.get(curChar) + 1;
                currentLength -= this.removeOldMatch(posMap, s, start, newIndex);
                start = newIndex;
            }
            posMap.put(curChar, sIndex);
            ++sIndex;
        }
        maxLength = (maxLength < currentLength) ? currentLength : maxLength; 
        return maxLength;
    }
    
    private int removeOldMatch(Map<Character , Integer> posMap, String s, int start, int newIndex) {
        for (int i = start; i < newIndex; ++i) {
            posMap.remove(s.charAt(i));
        }
        return newIndex - start - 1;
    }
}