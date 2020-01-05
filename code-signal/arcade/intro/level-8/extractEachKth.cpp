std::vector<int> extractEachKth(std::vector<int> a, int k) {
    int index = k-1;
    while (index < a.size()){
         a.erase (a.begin() + index);
         index = index - 1 + k;
    }
    return a;
}