int digitDegree(int n) {
    int sum;
    int degree =0;
    if (n<10) return 0;
    do {
        sum = 0;
        while (n >0){
            sum += n %10;
            n/=10;
        }
        n = sum;
        degree++;
    } while(sum > 9);
    return degree;
}
