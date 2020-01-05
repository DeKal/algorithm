int avoidObstacles(std::vector<int> a) {
    bool b[10000] = {0};
    int max = 0;
    for (int i = 0; i<a.size(); ++i){
        b[a[i]] = true;
        if (a[i]>max)
            max = a[i];
    }
    for (int i = 2; i <= 1000; ++i){
        int tmp = i;
        while(!b[tmp] && tmp<=max){
            
            tmp +=i;
        }
        if (tmp>max)
            return i;
    }
}