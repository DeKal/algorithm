std::vector<int> sortByHeight(std::vector<int> a) {
    std::vector<int> b(a);
    sort(b.begin(), b.end());
    b.erase(std::remove(b.begin(), b.end(), -1), b.end());
    int pos = 0;
    for (int i = 0; i<a.size(); ++ i){
        if (a[i]!=-1){
            a[i] = b[pos++];
        }
    }
    return a;
}