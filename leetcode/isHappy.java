
// https://leetcode.com/problems/happy-number
class isHappy {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = getNextGeneratedNumber(slow);
            fast = getNextGeneratedNumber(getNextGeneratedNumber(fast));

        } while (slow != fast && slow != 1 && fast != 1);

        return slow == 1 || fast == 1;
    }
    private int getNextGeneratedNumber(int n) {
        int result = 0;
        while (n>0) {
            int mod = n % 10;
            result += (int) Math.pow(mod, 2);
            n /= 10;
        }
        return result;
    }
}
