class Solution {
    
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        for (int index = 1; index <= n; ++index) {
            
            String text = "";
            if (index % 3 == 0 && index % 5 == 0)
                text = "FizzBuzz";
            else if (index % 3 == 0)
                text = "Fizz";
            else if (index % 5 == 0)
                text = "Buzz";
            else if (text.length() == 0)
                text += index;
            result.add(text);
        }
        return result;
    }
}