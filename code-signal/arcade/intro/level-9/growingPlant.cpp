int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
    int currentH = 0;
    int day = 0;
    while (currentH < desiredHeight){
        currentH += upSpeed;
        if (currentH >= desiredHeight)
            return day+1;
        currentH -= downSpeed;
        day++;
    }
}