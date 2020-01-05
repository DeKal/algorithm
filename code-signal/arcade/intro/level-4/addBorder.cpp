std::vector<std::string> addBorder(std::vector<std::string> p) {
    int n = p.size();
    int m = p[0].size();
    std::vector<std::string> a;
    string fullLine = "";
    for (int i = 0; i <m+2 ; ++ i){
        fullLine += "*";
    }
    a.push_back(fullLine);
    for (int i = 0; i < n; ++i){
        string bodyLine = "*";
        for (int j=0; j<m; ++j){
            bodyLine += p[i][j];
        }
        bodyLine += "*";
        a.push_back(bodyLine);
    }
    a.push_back(fullLine);
    return a;
}