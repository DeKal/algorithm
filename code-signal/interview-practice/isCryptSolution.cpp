long long decrypt(string s, int dict[]){
    long long res = 0;
    if (s.length() > 1 && dict[s[0] - 'A'] == 0)
        return -1;
    for (int i =0; i < s.length(); ++i)
        res = res*10 + dict[s[i] - 'A'];
    
    cout<< res << endl;
    return res;
}

bool isCryptSolution(std::vector<std::string> crypt, std::vector<std::vector<char>> solution) {
    long long a = 0;
    long long b = 0;
    long long c = 0;
    int dict[26] = {0};
    for (int i=0; i< solution.size(); ++i)
        dict[solution[i][0]-'A'] = solution[i][1]-'0';
    a = decrypt(crypt[0], dict);
    b = decrypt(crypt[1], dict);
    c = decrypt(crypt[2], dict);
    if (a==-1 || b ==-1 || c==-1)
        return false;
    return (a == c - b);
}