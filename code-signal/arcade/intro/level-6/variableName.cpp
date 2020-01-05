bool variableName(std::string name) {
    if (name[0]-'0' < 9)
        return false;
    for (int i=0; i<name.length(); ++i){
        if (!isDigit(name[i]) && !isUnderScore(name[i]) && ! isalpha(name[i]))
            return false;
    }
    return true;
}

bool isDigit(char a){
    return (a - '0'<=9 && a-'0'>=0);
}

bool isUnderScore(char a){
    return (a == '_');
}