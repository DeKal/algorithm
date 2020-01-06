class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        if (x < 10) return true;
        int reversePart = 0;
       
        while (x > reversePart) {
            reversePart = reversePart*10 + x%10;
            x /= 10;
        }
        
        return (x==reversePart || x==reversePart/10);
    }
}