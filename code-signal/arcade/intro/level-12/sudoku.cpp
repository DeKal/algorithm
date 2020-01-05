bool sudoku(std::vector<std::vector<int>> grid) {
    int row = grid.size();
    int col = grid[0].size();
    for (int i = 0; i<row; ++ i){
        set<int> checkSet;
        for (int j = 0; j<col; ++j){
            checkSet.insert(grid[i][j]);
        }
        if (checkSet.size() != 9)
            return false;
    }
    
    for (int j= 0; j<col; ++ j){
        set<int> checkSet;
        for (int i = 0; i<row; ++i){
            checkSet.insert(grid[i][j]);
        }
        if (checkSet.size() != 9)
            return false; 
    }
    
    
    for (int i= 0; i<row; i+=3){
        for (int j = 0; j<col; j+=3){
            set<int> checkSet;
            for (int ii =i; ii<i+3; ++ii){
                for (int jj =j; jj<j+3; ++jj){
                    checkSet.insert(grid[ii][jj]);
                }   
            }
            if (checkSet.size() != 9)
                return false; 
        }
        
    }
    
    return true;
}