char firstDigit(std::string s) {
    for (int i=0; i<s.length(); ++i){
        if (isdigit(s[i]))
            return s[i];
    }
 
}