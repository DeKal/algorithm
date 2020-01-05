std::string lineEncoding(std::string s) {
    string new_s = "";
    
    int count = 1;
    int i = 1;
    for (; i < s.length(); ++i){
        if (s[i-1] == s[i]){
            count++;
        }
        else{
            if (count == 1)
                new_s += s[i-1];
            else
                 new_s = new_s + to_string(count) +s[i-1];
            count = 1;
        }
    }
    if (count == 1)
        new_s += s[i-1];
    else
        new_s = new_s + to_string(count) +s[i-1];
    
    return new_s;
}