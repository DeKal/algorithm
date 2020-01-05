std::vector<std::string> allLongestStrings(std::vector<std::string> a) {
    std::vector<std::string> listStrings;
    int maxLength = 0;
    for (int i=0; i < a.size(); ++i){
        if (a[i].length()> maxLength)
            maxLength = a[i].length();
    }
    for (int i=0; i < a.size(); ++i){
        if (a[i].length()== maxLength)
            listStrings.push_back(a[i]);
    }
    return listStrings;
}