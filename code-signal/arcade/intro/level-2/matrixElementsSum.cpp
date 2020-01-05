int matrixElementsSum(std::vector<std::vector<int>> matrix) {
    int row = matrix.size();
    int column = matrix[0].size();
    int sum =0;
    for (int j =0; j<column; ++ j){
        for (int i=0; i<row; ++i)
            if (matrix[i][j] != 0){
                sum+=matrix[i][j];
            }
            else
                break;
    }
    return sum;
}