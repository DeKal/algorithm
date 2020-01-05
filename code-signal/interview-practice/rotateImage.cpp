void transpose(std::vector<std::vector<int>> & a){
    int row = a.size();
    int col = a[0].size();
    for (int i=0; i< row; ++i){
        for (int j = i+1; j <col; ++ j){
            swap(a[i][j], a[j][i]);
        }
    }
}

void reverseCol(std::vector<std::vector<int>> & a){
    int row = a.size();
    int col = a[0].size();
    for (int i=0; i< row; ++i){
        for (int j = 0; j < col/2; ++j){
            swap(a[i][j], a[i][col-j-1]);
        }
    }
}
std::vector<std::vector<int>> rotateImage(std::vector<std::vector<int>> a) {
    transpose(a);
    reverseCol(a);
    return a;
}
