class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0]; 
        
        int[] result = new int[nums.length - k + 1];
        
        Deque<Integer> window = new LinkedList<Integer>();
        
        for (int index = 0; index < k; ++index) {
            while (!window.isEmpty() && nums[index] >= nums[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(index);
        }
        
        for (int index = k; index < nums.length; ++index){
            result[index-k] = nums[window.peek()];
            
            while (!window.isEmpty() && window.peek() <= index - k) {
                window.removeFirst();
            }
            
            while (!window.isEmpty() && nums[index] >= nums[window.peekLast()]) {
                window.removeLast();
            }
            
            window.addLast(index);
        }
        
        result[nums.length - k] = nums[window.peek()];
        return result;
    }
}