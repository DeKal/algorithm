bool isInfiniteProcess(int a, int b) {
    if (a> b) return true;
    return ((b-a) %2 !=0);
}