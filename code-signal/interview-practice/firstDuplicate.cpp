int firstDuplicate(std::vector<int> a) {
    int minOccurrence = a.size();
    map<int, int> occurence;
    for (int i; i<a.size(); ++ i){
        std::map<int,int>::iterator it = occurence.find(a[i]);
        if (it != occurence.end()){
            it->second++;
            if (it->second == 2 && minOccurrence > i){
                minOccurrence = i;
            }
        }else{
            occurence[a[i]] = 1;
        }
    }
    if (minOccurrence == a.size())
        return -1;
    else
        return a[minOccurrence];
}
