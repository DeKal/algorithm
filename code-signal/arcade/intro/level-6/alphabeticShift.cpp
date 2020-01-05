std::string alphabeticShift(std::string s) {
    for (int i =0; i<s.length(); ++i)
        if (s[i] != 'z')
            s[i] = s[i] +1;
        else
            s[i] = 'a';
    return s;
}