int shapeArea(int n) {
    int area = 1;
    for (int i=2; i<=n; ++i){
        area = area + i*4 - 4;
    }
    return area;
}