
// https://leetcode.com/problems/pascals-triangle/submissions/
class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for (int i = 0; i<numRows; ++i) {
            List<Integer> newRow = new ArrayList<Integer>();
            if (i == 0) {
                newRow.add(1);

            } else {
                newRow.add(1);

                for (int j=1; j < i; ++j) {
                    newRow.add(pascalTriangle.get(i-1).get(j-1) + pascalTriangle.get(i-1).get(j));
                }
                newRow.add(1);
            }
            pascalTriangle.add(newRow);
        }
        return pascalTriangle;
    }
}