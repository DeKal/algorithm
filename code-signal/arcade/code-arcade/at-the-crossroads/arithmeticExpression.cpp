bool arithmeticExpression(int a, int b, int c) {
    if (a+b == c) return true;
    if (a-b == c) return true;
    if (a*b == c) return true;
    if (a/(b*1.0) == c) return true;
    return false;
}