int arrayMaximalAdjacentDifference(std::vector<int> a) {
    int max =0;
    for (int i = 1 ; i< a.size(); ++i){
        if (abs(a[i]-a[i-1]) > max)
            max = abs(a[i]-a[i-1]);
    }
    return max;
}