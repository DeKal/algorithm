int commonCharacterCount(std::string s1, std::string s2) {
    int a[26]={0};
    int b[26]={0};
    
    for (int i=0; i<s1.length(); ++i){
        a[s1[i]-'a']++;
    }
    for (int i=0; i<s2.length(); ++i){
        b[s2[i]-'a']++;
    }
    int sum = 0;
    for (int i=0; i<26; ++i){
        sum += min(a[i],b[i]);
    }
    return sum;
}