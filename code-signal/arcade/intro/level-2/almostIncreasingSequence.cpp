bool almostIncreasingSequence(std::vector<int> a) {
    int err = 0;
    
    for (int i=0; i < a.size() -1; ++ i){
        if (a[i] >= a[i + 1]){
            err++;
            if (err == 2) return false;
            if (i>0 && i+2<a.size() && a[i-1]>=a[i+1] && a[i]>=a[i+2])
                return false;
        }
    }

    return true;
}