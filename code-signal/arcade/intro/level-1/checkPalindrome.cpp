bool checkPalindrome(std::string inputString) {
    int n = inputString.length();
    for (int i = 0; i < n/2; ++i){
        if (inputString[i] != inputString[n-i-1])
            return false;
    }
    return true;
}