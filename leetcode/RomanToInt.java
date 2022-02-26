import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );


        int result = 0;
        for (int i = 0; i< s.length(); ++i) {

            while (i+1 < s.length() &&  map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                result -= map.get(s.charAt(i));
                ++i;
            }
            result += map.get(s.charAt(i));
        }
        return result;
    }
}
