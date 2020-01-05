int lateRide(int n) {
    int min = n /60;
    int sec = n %60;
    return min/10 + min %10 + sec %10 + sec/10;
}