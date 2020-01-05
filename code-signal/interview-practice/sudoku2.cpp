bool sudoku2(std::vector<std::vector<char>> grid) {
    int row = grid.size();
    int col = grid[0].size();
    for (int i=0; i<row; ++i){
        bool a[10] = {0};
        for (int j=0; j<col; ++j){
            if (grid[i][j] != '.'){
                if (a[grid[i][j] - '0'])
                    return false;
                a[grid[i][j] - '0'] = true;  
            } 
        }
    }
    
    for (int j=0; j<col; ++j){
        bool a[10] = {0};
        for (int i=0; i<row; ++i){
            if (grid[i][j] != '.'){
                if (a[grid[i][j] - '0'])
                    return false;
                a[grid[i][j] - '0'] = true;  
            } 
        }
    }
    
    for (int i=0; i<row; i+=3){
        for (int j=0; j<col; j+=3){
            bool a[10] = {0};
            
            for(int z=i; z<i+3; ++ z){
                for (int zz=j; zz<j+3; ++zz){
                    if (grid[z][zz] != '.'){
                            if (a[grid[z][zz] - '0'])
                                return false;
                            a[grid[z][zz] - '0'] = true;  
                        } 
                }
            }
        }
            
    }
    
    return true;
}