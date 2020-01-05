std::string longestWord(std::string text) {
    string newString = "";
    for (int i=0; i <text.length(); ++i){
        if (isalpha(text[i]) || text[i] == ' ')
            newString+=text[i];
        else
            newString+= " ";
    }

    int max = 0;
    string res ="";
    int i = 0;
    while (i <newString.length()){
        int j= i; 
        while(newString[j] != ' ' && j <newString.length()){
            j++;
        }
        if (j-i > max){
            max = j-i;
            res = newString.substr(i, j-i);
        }
        i = j + 1;
    }
    return res;
}