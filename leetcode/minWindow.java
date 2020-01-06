class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() < t.length()) return "";
       
        Map<Character, Integer> targetOccurMap = this.stringToOccurMap(t);
        
        String sFirstMatch = s.substring(0, t.length());
        Map<Character, Integer> srcOccurMap = this.stringToOccurMap(sFirstMatch);
        
        if (!checkDiffMaps(srcOccurMap, targetOccurMap))
            return s.substring(0, t.length());
        
        String result = s + " ";
        int rightIndex = t.length() - 1;
        int leftIndex = 0;
        while (rightIndex < s.length() - 1) {
            while (rightIndex < s.length()-1 && checkDiffMaps(srcOccurMap, targetOccurMap)) {
                rightIndex++;  
                Character curChar = s.charAt(rightIndex);
                int charOccur = srcOccurMap.containsKey(curChar) ? srcOccurMap.get(curChar) : 0;
                srcOccurMap.put(curChar, charOccur + 1);
            }

            if (checkDiffMaps(srcOccurMap, targetOccurMap))
                break;
            
            boolean isDiff = checkDiffMaps(srcOccurMap, targetOccurMap);
            while (leftIndex < rightIndex && !isDiff) {
                Character curChar = s.charAt(leftIndex);
                srcOccurMap.put(curChar, srcOccurMap.get(curChar) - 1);
                leftIndex++; 
                isDiff = checkDiffMaps(srcOccurMap, targetOccurMap);
            }
            
            String calcResult;
             if (isDiff)
                calcResult = s.substring(leftIndex-1, rightIndex+1);  
            else
                calcResult = s.substring(leftIndex, rightIndex+1); 
            
            if (calcResult.length() < result.length()) {
                result = calcResult;
                   
                if (result.length() == 1)
                    break;
            } 

        }
        
        return (result.length() == s.length() +  1) ? "" : result;
    }
    
    private Map<Character, Integer> stringToOccurMap(String str) {
        Map<Character, Integer> occurenceMap = new HashMap<>();
        for (int index = 0; index < str.length(); ++index) {
            Character curChar = str.charAt(index);
            int occurrenceTime = 1;
            if (occurenceMap.containsKey(curChar)) {
                occurrenceTime = occurenceMap.get(curChar) + 1;
            }
           
            occurenceMap.put(curChar, occurrenceTime);
        }
        
        return occurenceMap;
    }
    
    private boolean checkDiffMaps(Map<Character, Integer> occMap1, Map<Character, Integer> occMap2) {
        int diff = 0;
        for (Map.Entry<Character, Integer> entry : occMap2.entrySet()) {
            Character key = entry.getKey();
            Integer occurTimes = entry.getValue();
            if (!occMap1.containsKey(key)) {
                diff += occurTimes;
            } else {
                diff += Math.max(occurTimes - occMap1.get(key), 0);
            }
        }
        return (diff != 0);
    }
}