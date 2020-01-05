std::vector<std::vector<int>> minesweeper(std::vector<std::vector<bool>> matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    std::vector<std::vector<int>> res;
    for (int i=0; i <n; ++i){
        std::vector<int> row (m, 0);
        res.push_back(row);
    }
    
    for (int i=0; i<n; ++i){
        for (int j=0; j<m; ++j){
            if (i>0) res[i][j]+= matrix[i-1][j];
            if (i<n-1) res[i][j]+= matrix[i+1][j];
            if (j>0) res[i][j]+= matrix[i][j-1];
            if (j<m-1) res[i][j]+= matrix[i][j+1];
            
            if (i>0 && j>0) res[i][j]+= matrix[i-1][j-1];
            if (i>0 && j<m-1) res[i][j]+= matrix[i-1][j+1];
            if (i<n-1 && j>0) res[i][j]+= matrix[i+1][j-1];
            if (i<n-1 && j<m-1) res[i][j]+= matrix[i+1][j+1];
        }
    }
    return res;
        
}