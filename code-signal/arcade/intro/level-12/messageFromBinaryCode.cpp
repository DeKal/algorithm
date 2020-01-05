std::string messageFromBinaryCode(std::string code) {
    int a[8] = {128,64,32,16,8,4,2,1};
    string res = "";
    char tmp = 0;
    for (int i=0; i<code.length(); ++i)
    {
        tmp += a[i%8] * (code[i] - '0');
        if (i!=0 && (i+1)%8 ==0){
            res += tmp;
            tmp =0;
        }
            
    }
    return res;
}