std::string longestDigitsPrefix(std::string s) {
    int pos = 0;
    string res = "";
    while (isdigit(s[pos])){
        res += s[pos];
        pos++;
    }
    return res;
}