bool isLucky(int n) {
    int temp = n;
    int nDigits = 0;
    while (temp>0){
        nDigits++;
        temp/=10;
    }
    temp = n;
    int sum = 0;
    int curDigit = 0;
    while (temp>0){
        if (++curDigit <= nDigits/2){
            sum +=temp%10;
        }
        else{
            sum -=temp%10;
        }
        temp/=10;
    }
    
    return (sum==0)? 1:0;
}