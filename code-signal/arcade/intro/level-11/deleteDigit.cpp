int deleteDigit(int n) {
    String s = Integer.toString(n);
    int max = 0;
    for (int i=0; i<s.length(); ++i){
        String tmp = s.substring(0, i) + s.substring(i + 1);
        int new_num = Integer.parseInt(tmp);
        if (new_num > max)
            max = new_num;
    }
    return max;
}