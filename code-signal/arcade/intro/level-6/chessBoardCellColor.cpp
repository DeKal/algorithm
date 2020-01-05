bool chessBoardCellColor(std::string cell1, std::string cell2) {
    
    int col1 = cell1[0] - 'A' + 1;
    int col2 = cell2[0] - 'A' + 1;
    int row1 = cell1[1] - '0';
    int row2 = cell2[1] - '0';
    return (col1+row1)%2 == (col2+row2)%2;
}