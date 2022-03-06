// https://leetcode.com/contest/weekly-contest-283/problems/cells-in-a-range-on-an-excel-sheet/
public class cellsInRange {
    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();

        for (int i=s.charAt(0); i<=s.charAt(3); i++) {
            for (int j=s.charAt(1); j <=s.charAt(4); ++j) {
                String ch1 = Character.toString((char) i);
                String ch2 = Character.toString((char) j);
                ans.add(ch1+ch2);
            }
        }

        return ans;
    }
}
