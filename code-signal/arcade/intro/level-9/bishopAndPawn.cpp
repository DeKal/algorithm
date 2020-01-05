bool bishopAndPawn(std::string bishop, std::string pawn) {
    int colb = bishop[0] - 'A' +1;
    int rowb = bishop[1] - '0';
    int colp = pawn[0] - 'A' +1;
    int rowp = pawn[1] - '0';
    if (colb == colp || rowb == rowp)
        return false;
    if ( (colb+rowb)%2 == (colp+rowp)%2)
        return true;
    return false;
}