int phoneCall(int min1, int min2_10, int min11, int s) {
    int min = 0;
    while (s>0){
        
        min++;
        cout << min << ":" << s <<endl;
        if (min == 1){
            s-= min1;
        }
        else if (2<=min && min<=10){
            s-= min2_10;
        }
        else{
            s-= min11;
        }
    }
    if (s<0)
        return min-1;
    else
        return min;
}
