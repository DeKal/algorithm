class Solution {
    private final static String BACK = "..";
    private final static String CURRENT = ".";
    
    public String simplifyPath(String path) {
        if (path.length() == 0) return "";
        
        String[] splitedPaths = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String splitedPath : splitedPaths) {
            if (splitedPath.equals(BACK)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (splitedPath.length() > 0 && 
                       !splitedPath.equals(CURRENT)) {
                stack.push(splitedPath);    
            } 
        }
        
        
        return getDirectory(stack);
    }
    
    private String getDirectory(Stack<String> stack) {
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
           
            builder.insert(0, stack.peek());
            builder.insert(0, "/");
            stack.pop();
        }
        if (builder.length() == 0)
            return "/";
        else
            return builder.toString();
    }
}