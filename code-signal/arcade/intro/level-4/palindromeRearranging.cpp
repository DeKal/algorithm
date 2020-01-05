bool palindromeRearranging(std::string s) {
    int a[26] = {0};
    for (int i=0; i < s.length(); ++ i)
        a[s[i] - 'a']++;
    int err = 0;
    for (int i=0; i <26; ++i)
        if (a[i] % 2 !=0){
            err++;
            if (err == 2)
                return false;
        }
    return true;
}