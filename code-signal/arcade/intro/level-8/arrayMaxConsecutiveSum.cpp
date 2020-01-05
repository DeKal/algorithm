int arrayMaxConsecutiveSum(std::vector<int> a, int k) {
    int max = 0;
    for (int i=0; i <k; ++i)
        max += a[i];
    int currentSum = max;
    for (int i=k; i<a.size(); ++i){
        currentSum = currentSum - a[i-k] + a[i];
        if (currentSum > max)
            max = currentSum;
    }
    return max;
}