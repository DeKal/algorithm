
// https://leetcode.com/contest/weekly-contest-282/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
class minSteps {
    public int minSteps(String s, String t) {
        Map<Character, Integer> collection = new HashMap<>();
        for (int i=0; i<s.length(); ++i) {
            if (collection.containsKey(s.charAt(i))) {
                collection.put(s.charAt(i), collection.get(s.charAt(i))+ 1);
            } else {
                collection.put(s.charAt(i), 1);
            }
        }

        for (int i=0; i<t.length(); ++i) {
            if (collection.containsKey(t.charAt(i))) {
                collection.put(t.charAt(i), collection.get(t.charAt(i)) - 1);
            } else {
                collection.put(t.charAt(i), -1);
            }
        }

        int result = 0;
        for (Map.Entry<Character, Integer> entry : collection.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            result += Math.abs(value);
        }

        return result;
    }
}
