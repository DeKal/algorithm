int absoluteValuesSumMinimization(std::vector<int> a) {
    return ( absoluteValuesSum(a, a[a.size()/2-1]) <= absoluteValuesSum(a, a[a.size()/2]) ) 
        ? a[a.size()/2-1] : a[a.size()/2];
}

int absoluteValuesSum(std::vector<int> a, int x) {
    int sum = 0;
    for (int i=0; i<a.size(); ++i)
        sum+= abs(a[i] -x);
    return sum;
}