std::vector<int> arrayReplace(std::vector<int> a, int elemToReplace, int substitutionElem) {
    for (int i=0; i < a.size(); ++i){
        if (a[i] == elemToReplace)
            a[i] = substitutionElem;
    }
    return a;
}