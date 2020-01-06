class Solution {
    private static final Set<Character> OPEN_BRACKET_SET = new HashSet<>(Arrays.asList('{', '[','('));
    
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        for (int strIndex = 0; strIndex < s.length(); ++ strIndex) {
            char curChar = s.charAt(strIndex);
            if (OPEN_BRACKET_SET.contains(curChar)) {
                stack.push(curChar);
            } else if (!stack.isEmpty() && isMatchingBrackets(stack.peek(), curChar)){
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
                                                                                               
    private boolean isMatchingBrackets(char openBracket, char closeBracket) {
        if (openBracket == '(' && closeBracket == ')')
            return true;
        if (openBracket == '[' && closeBracket == ']')
            return true;
        if (openBracket == '{' && closeBracket == '}')
            return true;
        
        return false;
    }                                                                                
}