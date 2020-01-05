bool isBeautifulString(std::string s) {
    std::map<char,int> a;
    for (int i=0; i<s.length(); ++i)
        if (a.find(s[i]) == a.end())
            a[s[i]] = 1;
        else{
            a[s[i]] ++;
        }
    
    for (int i= 'b'; i<='z'; ++i){
        if (a.find(i-1) == a.end() && a.find(i) != a.end()){
            return false;
        }
        if (a.find(i-1) != a.end() && a.find(i) != a.end()){
            if (a[i] > a[i-1]) return false;
        }
    }
    return true;
}