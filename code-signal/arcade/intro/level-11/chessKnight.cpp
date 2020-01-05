int chessKnight(std::string cell) {
    int move_x[8] = {1,2, 2, 1,-1,-2,-2,-1};
    int move_y[8] = {2,1,-1,-2,-2,-1, 1, 2};
    int count = 0;
    for (int i=0 ; i<8; ++i){
        string moveCell = cell;
        moveCell[0] += move_x[i];
        moveCell[1] += move_y[i];
        if (isInBoard(moveCell))
            count++;
    }
    return count;
}

bool isInBoard(string a){
    return isInRange(a[0]) && isInRange(a[1]);
}

bool isInRange(char a){
    return ('1' <=a && a <= '8' ) || ('a' <=a && a<='h');
}