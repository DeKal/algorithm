class Solution {
    public String longestPalindrome(String s) {
        boolean[][] isPalindromeArr = this.getInitMatrix(s);
        return calcPalindromeSubString(isPalindromeArr, s);
    }
   
    private boolean[][] getInitMatrix(String s) {
        int length = s.length();
        boolean[][] isPalindromeArr = new boolean[length][length];
        for (int col = 0; col < s.length(); ++col) {
            for (int row = 0; row <= col; ++row) {
                if (row == col) {
                    isPalindromeArr[row][col] = true;
                }
                else {
                    isPalindromeArr[row][col] = false;
                }
            }
        }
        return isPalindromeArr;
    }
    
     private String calcPalindromeSubString(boolean[][] isPalindromeArr, String s) {
        int maxPalindrome = 0;
        int palindromeStart = -1;
        
         for (int col = 0; col < s.length(); ++col) {
            for (int row = 0; row <= col; ++row) {
                if (s.charAt(col) == s.charAt(row) ) {
                    if (row + 1 <= col - 1) {
                        isPalindromeArr[row][col] =  isPalindromeArr[row + 1][col - 1];
                    }
                    else {
                        isPalindromeArr[row][col] = true;
                    }
                    
                    if (isPalindromeArr[row][col] && maxPalindrome < col - row + 1) {
                        maxPalindrome = col - row + 1;
                        palindromeStart = row; 
                    }
                }
            }
        }
         
        if (palindromeStart != -1) {
            return s.substring(palindromeStart, palindromeStart + maxPalindrome);
        }
        else {
            return "";
        }
    }
    
}