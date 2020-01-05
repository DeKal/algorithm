int arrayChange(std::vector<int> a) {
    int move = 0;
    for (int i =1; i<a.size(); i++)
        if (a[i-1] >= a[i]){
            move += a[i-1] - a[i] + 1;
            a[i] = a[i-1] + 1;
        }
    return move;
}