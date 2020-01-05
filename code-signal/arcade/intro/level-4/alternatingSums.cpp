std::vector<int> alternatingSums(std::vector<int> a) {
    int s1 = 0;
    int s2 = 0;
    for (int i=0; i <a.size(); ++i){
        if (i%2 == 0){
            s2+= a[i];
        }
        else{
            s1+=a[i];
        }
    }
    std::vector<int> res;
    res.push_back(s2);
    res.push_back(s1);
    return res;
}