std::string buildPalindrome(std::string st) {
    string  rSt = st;
    std::reverse(rSt.begin(), rSt.end());
    string st2 = rSt + "#" + st;
    
    //KMP table
    int f[100] = {0};
    int j = 0;
    int i = 1;
    while (i<st2.length()){
        if (st2[i] == st2[j]){
            j++;
            f[i] = j;
            i++;
        }
        else{
            if (j == 0){
                f[i++] = 0;
            }
            else{
                j = f[j-1];
            }
        }
    }
    
    int pos = f[st2.length()-1];
    return st + rSt.substr(pos);
}
