std::vector<std::vector<int>> boxBlur(std::vector<std::vector<int>> a) {
    int n = a.size();
    int m = a[0].size();
    std::vector<std::vector<int>> res;
    for (int i = 1; i<n-1; ++ i){
        std::vector<int> row (m-2, 0); 
        res.push_back(row);
        for (int j = 1; j<m-1; ++j)
            res[i-1][j-1] = (int) blur(a,i,j);
        
    }
    return res;
}

double blur(std::vector<std::vector<int>> &a, int x, int y) {
 
    double res = 0;
    for (int i = x-1; i<=x+1; ++ i)
        for (int j = y-1; j<=y+1; ++j)
            res += a[i][j];
    return res/9;
           
}