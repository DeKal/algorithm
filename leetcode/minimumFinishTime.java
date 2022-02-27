// https://leetcode.com/problems/minimum-time-to-finish-the-race/
public class minimumFinishTime {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int inf = 2147483647;
        int[] goStraight = new int[19];
        Arrays.fill(goStraight, inf);
        // Find all go straight min solutions
        for (int i=0; i<tires.length; ++i) {
            goStraight[1] = Math.min(goStraight[1], tires[i][0]);
            int goStraightForTire = tires[i][0];
            int currentCost = tires[i][0];

            // 2^18 = 131072
            for (int j=2; j<19;  ++j) {
                currentCost *= tires[i][1];
                goStraightForTire += currentCost;
                // With max tire with value = 100000, change time = 100000 => max cost when change tire = 200000
                // => change tire is always better when go straight cost > 200000
                // => we dont need to calculate more if goStraightForTire > 200000
                if (goStraightForTire > 200000) {
                    break;
                }
                goStraight[j] = Math.min(goStraight[j], goStraightForTire);
            }
        }

        int dp[] = new int[numLaps+1];

        for (int i=1; i<=numLaps; ++i) {
            // base case: go straight min soluton
            dp[i] = (i < 19) ? goStraight[i] : inf;
            // i/2 +1 because the case will repeat when j > i/2
            for (int j = 1; j < i/2+1; ++ j) {
                // min lap i = min (
                // base case,
                // minimal solution in j first lap, then change tire, and minimal solution for the rest i-j
                // )
                dp[i] = Math.min(dp[i], dp[j] + changeTime + dp[i-j]);
            }
        }

        return dp[numLaps];

    }
}
