// https://leetcode.com/contest/weekly-contest-282/problems/minimum-time-to-complete-trips/
class minimumTime {
    private boolean isFinishedTrip(int[] time, int totalTrips, long middle) {
        long temp = 0;
        for (int i = 0; i < time.length; ++i) {
            temp += middle/time[i];
        }
        return temp >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long result = 0;
        long max = 0;
        for (int i=0; i<time.length; ++ i) {
            if (max < time[i]) {
                max = time[i];
            }
        }
        max *= totalTrips;

        long min = 1;

        while (min < max-1) {
            long middle = (min + max)/2;

            if (!isFinishedTrip(time,totalTrips, middle)) {
                min = middle;
            } else {
                max = middle;
            }
        }

        if (isFinishedTrip(time,totalTrips, min)) {
            return min;
        } else {
            return max;
        }

    }
}
