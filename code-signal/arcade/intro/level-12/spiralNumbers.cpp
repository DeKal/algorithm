std::vector<std::vector<int>> spiralNumbers(int n) {

    std::vector<std::vector<int>> a(n);
    for ( int i = 0 ; i < n ; i++ )
		a[i].resize(n);
    
    int count = 1;
    int direction = 0;
    int i=0;
    int j=0;
    while (count <= n*n){
        a[i][j] = count++;
        goDirection(direction, i, j, a, n);
    }
    return a;
}

void goDirection(int & direct, int&i, int &j, std::vector<std::vector<int>> &a, int n){
    switch(direct) {
        case 0 :
            if (j<n-1 && a[i][j+1] == 0)
                j++;
            else{
                direct++;
                ++i;
            }
            break;  
        case 1 :
            if (i<n-1 && a[i+1][j] == 0)
                i++;
            else{
                --j;
                direct++;
            }
            break;  
        case 2 :
            if (j>0 && a[i][j-1] == 0)
                j--;
            else{
                --i;
                direct++;
            }
            break;       
        case 3 :
            if (i>0 && a[i-1][j] == 0)
                i--;
             else{
                 ++j;
                direct = 0;
             }
            break;
    }
}