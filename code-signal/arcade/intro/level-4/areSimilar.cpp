bool areSimilar(std::vector<int> a, std::vector<int> b) {
    int c[3];
    int count =0;
    for (int i=0; i<a.size(); ++i){
        if (a[i] != b[i]){
            c[count] = i;
            if (++count > 2 )
                return false;
        }
    }
    if (count ==1) return false;
    if (count ==2 &&(a[c[0]] != b[c[1]] || a[c[1]] != b[c[0]])) return false;
    return true;
        
}